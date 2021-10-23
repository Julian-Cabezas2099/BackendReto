package com.Reto3.springboot.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reto3.springboot.app.Models.entities.Reservation;
import com.Reto3.springboot.app.Repository.ReservationRepository;

@Service
/**
 * Clase Servicio para reservas
 */
public class ReservationService {
	   @Autowired
	   /**
 		* objeto repositorio reservas
		 */
	    private ReservationRepository repositoryR;
		/**
 		* método para consultar todas las reservas
		 */
	    public List<Reservation> getAll(){
	        return repositoryR.getAll();
	    }
		/**
 		* método para consultar una reserva por id
		 */
	    public Optional<Reservation> getReservation(int reservationId) {
	        return repositoryR.getReservation(reservationId);
	    }
		/**
 		* método para guardar una reserva
		 */
	    public Reservation save(Reservation reservation){
			
	        if(reservation.getIdReservation()==null){
	            return repositoryR.save(reservation);
	        }else{
	            Optional<Reservation> e= repositoryR.getReservation(reservation.getIdReservation());
	            if(e == null){
	                return repositoryR.save(reservation);
	            }else{
	                return reservation;
	            }
	        }
	    }
		/**
 		* método para actualizar la info de una reserva
		 */
	    public Reservation update(Reservation reservation){
	        if(reservation.getIdReservation()!=null){
	            Optional<Reservation> e= repositoryR.getReservation(reservation.getIdReservation());
	            if( e != null){

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
		/**
 		* método para eliminar una reserva por id
		 */
	    public boolean deleteReservation(int reservationId) {
	        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
	        	repositoryR.delete(reservation);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
}
