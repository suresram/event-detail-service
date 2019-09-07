package com.s2.trip.query.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2.trip.query.model.Trip;
import com.s2.trip.query.repository.TripQueryRepository;

@Service
public class TripQueryService {

	@Autowired
	private TripQueryRepository tripQueryRepository;
	
	enum Roles {
		  RIDER,
		  DRIVER,
		  ADMIN
		} 
	public List<Trip> getTripSummary(String userId, String roles) {
		if(StringUtils.contains(roles, Roles.ADMIN.name())) {
			return tripQueryRepository.findAll();
		}else if(StringUtils.contains(roles, Roles.DRIVER.name())) {
			return tripQueryRepository.findByDriverId(userId);
		}else {
			return tripQueryRepository.findByRiderId(userId);
		}
		
	}
}
