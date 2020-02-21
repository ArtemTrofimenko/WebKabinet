package com.web_kabinet.repos;

import com.web_kabinet.domain.Driver;
import org.springframework.data.repository.CrudRepository;


public interface DriverRepo extends CrudRepository<Driver, String> {
}
