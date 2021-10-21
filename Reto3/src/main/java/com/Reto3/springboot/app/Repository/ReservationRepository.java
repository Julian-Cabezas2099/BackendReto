package com.Reto3.springboot.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Reto3.springboot.app.CrudRepository.ReservationCrudRepository;
import com.Reto3.springboot.app.Models.entities.Reservation;

@Repository
public class ReservationRepository {

	 @Autowired
	    private ReservationCrudRepository reservationR;

	    public List<Reservation> getAll(){
	        return (List<Reservation>) reservationR.findAll();
	    }
	    public Optional<Reservation> getReservation(int id){
	        return reservationR.findById(id);
	    }
	    public Reservation save(Reservation reservation){
	        return reservationR.save(reservation);
	    }
	    public void delete(Reservation reservation){
	    	reservationR.delete(reservation);
	    }
}
