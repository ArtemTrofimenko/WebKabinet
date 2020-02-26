package com.web_kabinet.repos;

import com.web_kabinet.request.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepo extends CrudRepository<Request, String> {
    @Query(value = "select max(num) from request", nativeQuery = true)
    Long findMaxNum();
}
