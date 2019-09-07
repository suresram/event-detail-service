package com.s2.trip.query.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.s2.trip.query.model.Trip;

public interface TripQueryRepository extends MongoRepository<Trip, String> {

	List<Trip> findByRiderId(String riderId);
	List<Trip> findByDriverId(String riderId);

}