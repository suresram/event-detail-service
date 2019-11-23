package com.s2.trip.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.s2.trip.query.model.Trip;
import com.s2.trip.query.service.TripQueryService;

@Controller
public class TripQueryController {

	@Autowired
	private TripQueryService tripQueryService;
	
	@RequestMapping(value = "trip-query/v1/summary", method = RequestMethod.GET)
	@ResponseBody
	public List<Trip> getTripSummary(@RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) {
		return tripQueryService.getTripSummary(userId, roles);
	}
}
