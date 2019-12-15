package com.s2.event.detail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.s2.event.detail.model.Event;

public interface EventDetailRepository extends MongoRepository<Event, String> {

	List<Event> findByEventStatus(String eventStatus);

}