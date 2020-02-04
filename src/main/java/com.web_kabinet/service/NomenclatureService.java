package com.web_kabinet.service;

import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.repos.NomenclatureRepo;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureService {
    private NomenclatureRepo nomenclatureRepo;

    public NomenclatureService(NomenclatureRepo nomenclatureRepo) {
        this.nomenclatureRepo = nomenclatureRepo;
    }

    public Nomenclature findNomenclatureByUUID (String nomenclatureId){
        return nomenclatureRepo.findById(nomenclatureId).orElseThrow(NullPointerException::new);
    }
}
