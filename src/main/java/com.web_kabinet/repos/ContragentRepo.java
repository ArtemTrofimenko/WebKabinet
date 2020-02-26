package com.web_kabinet.repos;

import com.web_kabinet.domain.Contragent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContragentRepo extends CrudRepository<Contragent, String> {
    @Override
    List<Contragent> findAll();




}
