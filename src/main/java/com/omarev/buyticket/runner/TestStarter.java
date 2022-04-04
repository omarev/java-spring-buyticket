package com.omarev.buyticket.runner;

import com.omarev.buyticket.entity.Event;
import com.omarev.buyticket.entity.Ticket;
import com.omarev.buyticket.repository.EventRepository;
import com.omarev.buyticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.time.LocalDateTime;

@Component
public class TestStarter implements CommandLineRunner {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String... args) throws Exception {
        Event event = new Event();
        event.setName("Java Event 2022");
        event.setDate(LocalDateTime.parse("2022-04-04T10:00:00"));

        eventRepository.save(event);

        Ticket discountedTicket = new Ticket();
        discountedTicket.setEventId(event.getId());
        discountedTicket.setName("Discounted");
        discountedTicket.setPrice(8.2d);

        Ticket regularTicket = new Ticket();
        regularTicket.setEventId(event.getId());
        regularTicket.setName("Regular");
        regularTicket.setPrice(10d);

        Ticket vipTicket = new Ticket();
        vipTicket.setEventId(event.getId());
        vipTicket.setName("VIP");
        vipTicket.setPrice(50d);

        Event futureEvent = new Event(
                null,
                "Java Event 2023",
                LocalDateTime.parse("2023-04-04T10:00:00")
        );

        eventRepository.save(futureEvent);

        Ticket earlyBirdTicket = new Ticket();
        earlyBirdTicket.setEventId(futureEvent.getId());
        earlyBirdTicket.setName("Early Bird");
        earlyBirdTicket.setPrice(10d);

        ticketRepository.saveAll(List.of(discountedTicket,regularTicket,vipTicket, earlyBirdTicket));
    }
}
