package com.projects.eventsconfirmer.config;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projects.eventsconfirmer.entities.Event;
import com.projects.eventsconfirmer.entities.Participant;
import com.projects.eventsconfirmer.repositories.EventRepository;
import com.projects.eventsconfirmer.repositories.ParticipantRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private ParticipantRepository participantRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Participant p1 = new Participant(null, "Carlos", "12345678", false);
		Participant p2 = new Participant(null, "Maria", "87654321", true);
		
		Event e1 = new Event(null, "Boiler", Instant.parse("2025-06-16T23:08:00Z"), "São Paulo", 450);
		Event e2 = new Event(null, "Gramadinho", Instant.parse("2025-06-16T23:08:00Z"), "Rio de Janeiro", 500);
		
		participantRepository.saveAll(Arrays.asList(p1, p2));
		eventRepository.saveAll(Arrays.asList(e1, e2));
	}
}