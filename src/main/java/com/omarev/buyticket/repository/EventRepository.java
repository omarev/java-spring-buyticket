package com.omarev.buyticket.repository;

import com.omarev.buyticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
