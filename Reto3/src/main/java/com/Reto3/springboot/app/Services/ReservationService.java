package com.Reto3.springboot.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reto3.springboot.app.Models.entities.Reservation;
import com.Reto3.springboot.app.Repository.ReservationRepository;

@Service
public class ReservationService {
	   @Autowired
	    private ReservationRepository repositoryR;

	    public List<Reservation> getAll(){
	        return repositoryR.getAll();
	    }

	    public Optional<Reservation> getReservation(int reservationId) {
	        return repositoryR.getReservation(reservationId);
	    }

	    public Reservation save(Reservation reservation){
	        if(reservation.getIdReservation()==null){
	            return repositoryR.save(reservation);
	        }else{
	            Optional<Reservation> e= repositoryR.getReservation(reservation.getIdReservation());
	            if(e.isEmpty()){
	                return repositoryR.save(reservation);
	            }else{
	                return reservation;
	            }
	        }
	    }

	    public Reservation update(Reservation reservation){
	        if(reservation.getIdReservation()!=null){
	            Optional<Reservation> e= repositoryR.getReservation(reservation.getIdReservation());
	            if(!e.isEmpty()){

	                if(reservation.getStartDate()!=null){
	                    e.get().setStartDate(reservation.getStartDate());
	                }
	                if(reservation.getDevolutionDate()!=null){
	                    e.get().setDevolutionDate(reservation.getDevolutionDate());
	                }
	                if(reservation.getStatus()!=null){
	                    e.get().setStatus(reservation.getStatus());
	                }
	                repositoryR.save(e.get());
	                return e.get();
	            }else{
	                return reservation;
	            }
	        }else{
	            return reservation;
	        }
	    }

	    public boolean deleteReservation(int reservationId) {
	        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
	        	repositoryR.delete(reservation);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
}
