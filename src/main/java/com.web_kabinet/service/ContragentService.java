package com.web_kabinet.service;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.repos.ContragentRepo;
import org.springframework.stereotype.Service;

@Service
public class ContragentService {

    private ContragentRepo contragentRepo;

    public ContragentService(ContragentRepo contragentRepo) {
        this.contragentRepo = contragentRepo;
    }

    public Contragent findContragentByUUID (String contragentId){
        return contragentRepo.findById(contragentId).orElseThrow(NullPointerException::new);
    }
}
