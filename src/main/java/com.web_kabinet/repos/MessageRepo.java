package com.web_kabinet.repos;

import com.web_kabinet.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTagContaining(String tag);
}
