package com.web_kabinet.service;

import com.web_kabinet.component.TtnComponent;
import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;
import com.web_kabinet.repos.RequestRepo;
import com.web_kabinet.repos.TtnRepo;
import com.web_kabinet.request.Request;
import com.web_kabinet.ttn.Ttn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class RequestService {
    @Autowired
    RequestRepo requestRepo;

    @Autowired
    TtnComponent ttnComponent;

    @Autowired
    TtnService ttnService;

    @Autowired
    TtnRepo ttnRepo;

    public Long getNumber() {
        Long num = 0L;
        Long max = 0L;
        max = requestRepo.findMaxNum();
        if (max == null) {
            return 1L;
        }
        num = max + 1L;
        return num;
    }

    public Boolean checkWeight(Request request) {
        List<String> contragent = Collections.singletonList(request.getContragent().getId());
        List<Ttn> ttns = ttnService.getTtnForContragent(contragent);

        List<Nomenclature> nomenclatureList = ttnService.getNomenclatureFromTtn(ttns);
        Map <String, String> ttnMap = ttnComponent.totTtn(ttns, nomenclatureList);

        String requestString = request.getContragent().getId() + request.getNomenclature().getId();

        return Float.parseFloat(ttnMap.get(requestString)) > request.getWeight();
    }

    public void ttnFromRequest(Request request, User user){

        Contragent contragent = request.getContragent();

        Long num = ttnService.getNumber();

        String key = contragent.getId() + request.getNomenclatureId();
        String rubbish = ttnComponent.getRubbishMap().get(key);
        String humidity = ttnComponent.getHumidityMap().get(key);

        Ttn ttn = Ttn.builder()
                .author(user)
                .request(request)
                .num(num)
                .rubbish(rubbish)
                .humidity(humidity)
                .build();
        ttnRepo.save(ttn);

    }
}
