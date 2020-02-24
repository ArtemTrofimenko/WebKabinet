package com.web_kabinet.service;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
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
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TtnService {
    @Autowired
    private ContragentService contragentService;
    @Autowired
    private NomenclatureService nomenclatureService;

    @Autowired
    private SessionFactory sessionFactory;

    private final TtnRepo ttnRepo;

    private String indexOfNumber = "ТТН";

    public TtnService(TtnRepo ttnRepo) {
        this.ttnRepo = ttnRepo;
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
//
//    public List<Ttn> loadTtnByContragent(User user) {
//        Contragent userContragent = user.getContragent();
//        return ttnRepo.findAllByContragentId(userContragent.getId());
//    }

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
    public Iterable<Ttn> getTtnForContragent(List<String> contragent_id)  {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Ttn.class);

        String[] ccc = {"2823c0d5-a5c0-4152-a60c-9547754d0094", "45fd02d4-35f7-455c-8945-29acc3d29f54"};

        Iterable <Ttn> ttns = criteria
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
}


