package com.Reto3.springboot.app.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


import com.Reto3.springboot.app.Models.entities.Reservation;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date devolutionDate);

    // public List<Reservation> findByStartDateBetween(Date startDate, Date devolutionDate);

    public List<Reservation> findByStatus(String status);
	

    @Query("SELECT COUNT(res.client) AS total, res.client  FROM Reservation AS res GROUP BY res.client ORDER BY total DESC")
    public List<Object[]> findTopClients();

    
	
	
}
