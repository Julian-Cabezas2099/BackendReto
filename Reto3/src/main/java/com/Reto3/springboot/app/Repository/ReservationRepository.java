package com.Reto3.springboot.app.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Reto3.springboot.app.CrudRepository.ReservationCrudRepository;
import com.Reto3.springboot.app.Models.entities.Client;
import com.Reto3.springboot.app.Models.entities.Reservation;
import com.Reto3.springboot.app.Models.reports.CountReservation;
import com.Reto3.springboot.app.Models.reports.TopClient;

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

		
		public List<Reservation> reporteFechas(Date date1, Date date2){

			// return (List<Reservation>) reservationR.findByStartDateBetween(date1, date2);
			return (List<Reservation>) reservationR.findAllByStartDateAfterAndStartDateBefore(date1, date2);
	  	}
	  
	  	public CountReservation getStatus(){

			CountReservation respuesta;


			int countCompleted = reservationR.findByStatus("completed").size();
			int countCancelled = reservationR.findByStatus("cancelled").size();

	    	respuesta = new CountReservation(countCompleted, countCancelled);

		  	return respuesta;
	  	}

		public List<TopClient> getTopClients(){

			List<TopClient> respuesta = new ArrayList<>();

			List<Object[]> report = reservationR.findTopClients();

			for (int i = 0; i < report.size(); i++) {
				
				TopClient topClient = new TopClient( (Long)report.get(i)[0] ,(Client) report.get(i)[1]);
				respuesta.add(topClient);
			}

			return respuesta;
		}
	  	
		
}
