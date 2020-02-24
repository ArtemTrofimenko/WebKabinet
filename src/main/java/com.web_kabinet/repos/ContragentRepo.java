package com.web_kabinet.repos;

import com.web_kabinet.domain.Contragent;
import org.springframework.data.repository.CrudRepository;


public interface ContragentRepo extends CrudRepository<Contragent, String> {
    @Override
    Iterable<Contragent> findAll();




}
