package com.web_kabinet.repos;

import com.web_kabinet.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<Vehicle, String> {

}
