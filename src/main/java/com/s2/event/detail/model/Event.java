package com.s2.event.detail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trips")
public class Event {

	@Id
	private String id;
	private String name;
	private String description;
	public String fromDateTime;
	public String toDateTime;
	public String status;
	public String pointOfContact;
	public EventLocation eventLocation;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public String getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPointOfContact() {
		return pointOfContact;
	}
	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}
	public EventLocation getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(EventLocation eventLocation) {
		this.eventLocation = eventLocation;
	}
}
