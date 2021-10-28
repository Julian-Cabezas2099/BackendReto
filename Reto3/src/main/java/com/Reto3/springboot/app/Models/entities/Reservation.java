package com.Reto3.springboot.app.Models.entities;

import java.io.Serializable;
// import java.sql.Date;
import java.util.Date;

// import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idReservation;
	    private Date startDate;
	    private Date devolutionDate;
	    private String status="created";
	    
	    // @ManyToOne(cascade = {CascadeType.ALL})
		@ManyToOne
	    @JoinColumn(name = "idBikeFk")
	    @JsonIgnoreProperties("reservations")
	    private Bike bike;

	    @ManyToOne
	    @JoinColumn(name = "idClientFk")
	    @JsonIgnoreProperties({"reservations","messages"})
	    private Client client;

	    private String score; //depende el grupo

	    public Integer getIdReservation() {
	        return idReservation;
	    }

	    public void setIdReservation(Integer idReservation) {
	        this.idReservation = idReservation;
	    }

	    public Date getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(Date startDate) {
	        this.startDate = startDate;
	    }

	    public Date getDevolutionDate() {
	        return devolutionDate;
	    }

	    public void setDevolutionDate(Date devolutionDate) {
	        this.devolutionDate = devolutionDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Bike getBike() {
	        return bike;
	    }

	    public void setBike(Bike bike) {
	        this.bike = bike;
	    }

	    public Client getClient() {
	        return client;
	    }

	    public void setClient(Client client) {
	        this.client = client;
	    }

	    public String getScore() {
	        return score;
	    }

	    public void setScore(String score) {
	        this.score = score;
	    }


    

}