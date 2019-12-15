package com.s2.event.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.s2.event.detail.model.Event;
import com.s2.event.detail.service.EventDetailService;

@Controller
public class EventDetailController {

	@Autowired
	private EventDetailService eventDetailService;

	@RequestMapping(value = "events/v1/{eventStatus}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEvents(@PathVariable String eventStatus,
			@RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) {
		return eventDetailService.getEvents(eventStatus, roles);
	}
}
