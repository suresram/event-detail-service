package com.s2.trip.query.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TripQueryController {

	@RequestMapping(value = "trip-query/summary", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(@RequestHeader(value = "username", required = true) String username,
			@RequestHeader(value = "roles", required = true) String roles) {
		System.out.println(username);
		System.out.println(roles);
		return "test";
	}
}
