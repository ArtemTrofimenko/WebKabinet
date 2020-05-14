package com.web_kabinet.service;

import com.web_kabinet.component.TtnComponent;
import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.TtnRepo;
import com.web_kabinet.ttn.Ttn;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TtnService {

    private SessionFactory sessionFactory;
    private ContragentService contragentService;
    private NomenclatureService nomenclatureService;
    private TtnComponent ttnComponent;

    @Autowired
    TtnService(SessionFactory sessionFactory, ContragentService contragentService, NomenclatureService nomenclatureService,
               TtnComponent ttnComponent, TtnRepo ttnRepo)
    {
        this.contragentService = contragentService;
        this.sessionFactory = sessionFactory;
        this.nomenclatureService = nomenclatureService;
        this.ttnComponent = ttnComponent;
        this.ttnRepo = ttnRepo;
    }

    private final TtnRepo ttnRepo;

    private String indexOfNumber = "ТТН";

    public TtnService(TtnRepo ttnRepo) { this.ttnRepo = ttnRepo;
    }

    public String getIndexOfNumber() {
        return indexOfNumber;
    }

    public void setIndexOfNumber(String indexOfNumber) {
        this.indexOfNumber = indexOfNumber;
    }

    public TtnRepo getTtnRepo() {
        return ttnRepo;
    }

    public Long getNumber() {
        Long num = 0L;
        Long max = 0L;
        max = ttnRepo.findMaxNum();
        if (max == null) {
            return 1L;
        }
        num = max + 1L;
        return num;
    }

    public Timestamp getTimestamp(String date) throws ParseException {
        Timestamp timestamp;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date d = format.parse(date);
        timestamp = new Timestamp(d.getTime());
        return timestamp;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED)
    public List<Ttn> getTtnForContragent(List<String> contragent_id)  {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Ttn.class);

        List <Ttn> ttns = criteria
                .add(  Restrictions.and
                        (Restrictions.in("contragent.id", contragent_id)))
                .list();

        return ttns;
    }

    public List <Nomenclature> getNomenclatureFromTtn(List<Ttn> ttns){
        List<Nomenclature> nomenclatureList = ttns.stream()
                .map((Ttn::getNomenclature))
                .distinct()
                .collect(Collectors.toList());
        return nomenclatureList;
    }

    public List <Contragent> getContragentsFromTtn(List<Ttn> ttns){
        List<Contragent> contragentList = ttns.stream()
                .map((Ttn::getContragent))
                .distinct()
                .collect(Collectors.toList());
        return contragentList;
    }

    public List<String> getContragentsId(List<Contragent> contragents){
       return contragents.stream()
                .map(Contragent::getId)
                .collect(Collectors.toList());
    }

    @Transactional
    public Map<String, Object> getTtnSearchResult(User user, String contragent_id){

        List<Ttn> ttns;
        Map<String, String> totalTtn;
        Map<String, Object> result = new HashMap<String, Object>();
        List<Contragent> contragentList;
        List <String> contragentsId;

        if (contragent_id.equals("")) {

            contragentList =  (user.isAdmin()) ? contragentService.findAll() : user.getUserContragents();

            contragentsId = getContragentsId (contragentList);

            ttns = getTtnForContragent(contragentsId);

            List<Nomenclature> nomenclatures = getNomenclatureFromTtn(ttns);
            totalTtn = ttnComponent.totTtn(ttns, nomenclatures);

        }
        else {

            contragentList = contragentService.findAllContragentByUUID(contragent_id);
            contragentsId = getContragentsId(contragentList);

            ttns =  getTtnForContragent(contragentsId);

            List<Nomenclature> nomenclatures = getNomenclatureFromTtn(ttns);
            totalTtn = ttnComponent.totTtn(ttns, nomenclatures);

        }

        result.put("ttnComponent", totalTtn);
        result.put("ttns", ttns);

        return result;
    }



}


