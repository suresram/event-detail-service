package com.s2.event.detail.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2.event.detail.model.Event;
import com.s2.event.detail.repository.EventDetailRepository;

@Service
public class EventDetailService {

	@Autowired
	private EventDetailRepository eventDetailRepository;

	enum Roles {
		VOLUNTEER, ADMIN
	}

	public List<Event> getEvents(String eventStatus, String roles) {
		if (StringUtils.contains(roles, Roles.ADMIN.name()) && StringUtils.equalsIgnoreCase(eventStatus, "all")) {
			return eventDetailRepository.findAll();
		} else {
			return eventDetailRepository.findByStatus(eventStatus);
		}
	}
}
