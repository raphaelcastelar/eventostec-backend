package com.eventostec.api.domain.repositories;

import com.eventostec.api.domain.event.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query("SELECT e FROM Event e WHERE e.date >= :currentDate")
    Page<Event> findUpcomingEvents(@Param("currentDate") Date currentDate, Pageable pageable);

    @Query("SELECT e FROM Event e " +
            "LEFT JOIN e.address a " +
            "WHERE e.date >= :currentDate " +
            "AND (:title IS NULL OR e.title LIKE CONCAT('%', :title, '%')) " +
            "AND (:city IS NULL OR a.city LIKE CONCAT('%', :city, '%')) " +
            "AND (:uf IS NULL OR a.uf LIKE CONCAT('%', :uf, '%')) " +
            "AND (:startDate IS NULL OR e.date >= :startDate) " +
            "AND (:endDate IS NULL OR e.date <= :endDate)")
    Page<Event> searchEvents(@Param("currentDate") Date currentDate,
                             @Param("title") String title,
                             @Param("city") String city,
                             @Param("uf") String uf,
                             @Param("startDate") Date startDate,
                             @Param("endDate") Date endDate,
                             Pageable pageable);
}
