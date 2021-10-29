package com.Reto3.springboot.app.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Reto3.springboot.app.Models.entities.Reservation;
import com.Reto3.springboot.app.Models.reports.CountReservation;
import com.Reto3.springboot.app.Models.reports.TopClient;
import com.Reto3.springboot.app.Services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ReservationController {

	  	@Autowired
	    private ReservationService service;
	    @GetMapping("/all")
	    public List<Reservation> getReservations(){
	        return service.getAll();
	    }

	    @GetMapping("/{id}")
	    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
	        return service.getReservation(reservationId);
	    }
	    @PostMapping("/save")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Reservation save(@RequestBody Reservation reservation) {
	        return service.save(reservation);
	    }
	    @PutMapping("/update")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Reservation update(@RequestBody Reservation reservation) {
	        return service.update(reservation);
	    }
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public boolean delete(@PathVariable("id") int reservationId) {
	        return service.deleteReservation(reservationId);
	    }

		@GetMapping("/report-dates/{fechainicio}/{fechafin}")
	    public List<Reservation> getReport(@PathVariable("fechainicio") String date1, @PathVariable("fechafin") String date2 ){
	        // return service.reporte(date1, date2);
			return service.reporteFechas(date1, date2);

	    }
	    
	    @GetMapping("/report-status")
	    public CountReservation statusRe(){
	        return service.countS();
	    }

		@GetMapping("/report-clients")
    	public List<TopClient> getClient(){
        return service.getTopClients();
    }
}
