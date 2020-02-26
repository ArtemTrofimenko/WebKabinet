package com.web_kabinet.component;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.Operation;
import com.web_kabinet.service.TtnService;
import com.web_kabinet.ttn.Ttn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.web_kabinet.domain.Operation.COMING;


@Component("ttnComponent")
public class TtnComponent {

    @Autowired
    TtnService ttnService;
    private Map<String, String> finalMap = new HashMap<>();

    public TtnComponent() {
    }

    public Map<String, String> totTtn(List<Ttn> ttns, List<Nomenclature> nomenclatures) {

        List<Contragent> contragents = ttnService.getContragentsFromTtn(ttns);

        for (Contragent contragent : contragents) {
            String contragent_id = contragent.getId();

            for (Nomenclature nom :
                    nomenclatures) {

                List<Float> plusTtn = new ArrayList<>();
                List<Float> minusTtn = new ArrayList<>();
                List<Ttn> ttnForOperation = ttns.stream()
                        .filter(ttn -> (ttn.getContragent().equals(contragent) && ttn.getNomenclature().equals(nom)))
                        .collect(Collectors.toList());

                for (Ttn t :
                        ttnForOperation) {
                    Operation operation = t.getOperation();

                        if (operation.equals(COMING)) {
                            plusTtn.add(t.getWeight());
                        } else {
                            minusTtn.add(t.getWeight());
                        }

                }

                Float plusSum = plusTtn.stream()
                        .reduce(Float::sum)
                        .orElse((float) 0);
                Float minusSum = minusTtn.stream()
                        .reduce(Float::sum)
                        .orElse((float) 0);

                String sum = String.valueOf(plusSum - minusSum);

                String key = keyIdGenerator(contragent_id, nom.getId());
                finalMap.put(key, sum);
            }


        }

        return finalMap;
    }

    public Map<String, String> getFinalMap() {
        return finalMap;
    }

    private String keyIdGenerator(String contragent_id, String nomenclature_id){
        return contragent_id+nomenclature_id;
    }
}
