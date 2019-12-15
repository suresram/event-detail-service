package com.s2.event.detail;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.s2.event.detail.EventDetailApplication;
import com.s2.event.detail.model.Event;
import com.s2.event.detail.model.EventLocation;
import com.s2.event.detail.repository.EventDetailRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventDetailApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class EventDetailApplicationTest {

	@LocalServerPort
	private int port;

	@MockBean
	private EventDetailRepository eventDetailRepository;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testAllOpenEvents() throws Exception {
		Mockito.when(eventDetailRepository.findByStatus(Mockito.anyString())).thenReturn(EventDetailApplicationTest.mockEvent());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("userId", "admin1");
		headers.set("roles", "ADMIN");
		ResponseEntity<String> response = restTemplate.exchange(
				new URL("http://localhost:" + port + "/events/v1/open").toString(), HttpMethod.GET,
				new HttpEntity<>(headers), String.class);
		assertTrue(StringUtils.contains(response.getBody(), "eventName"));
	}

	@Test
	public void testAllEventsForAdmin() throws Exception {
		Mockito.when(eventDetailRepository.findAll()).thenReturn(EventDetailApplicationTest.mockEvent());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("userId", "admin1");
		headers.set("roles", "ADMIN");
		ResponseEntity<String> response = restTemplate.exchange(
				new URL("http://localhost:" + port + "/events/v1/all").toString(), HttpMethod.GET,
				new HttpEntity<>(headers), String.class);
		assertTrue(StringUtils.contains(response.getBody(), "eventName"));
	}

	public static List<Event> mockEvent() {
		List<Event> events = new ArrayList<Event>();
		Event event = new Event();
		event.setId("123");
		event.setName("eventName");
		event.setDescription("description");
		event.setPointOfContact("pointOfContact");
		event.setFromDateTime("01/01/2019 09:00:00");
		event.setToDateTime("01/01/2019 10:00:00");
		event.setStatus("OPEN");
		EventLocation eventLocation = new EventLocation();
		eventLocation.setAddress1("Address1");
		eventLocation.setAddress2("address2");
		eventLocation.setCity("city");
		eventLocation.setPinCode("12345");
		eventLocation.setState("TN");
		event.setEventLocation(eventLocation);
		events.add(event);
		return events;
	}
}
