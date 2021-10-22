package com.Reto3.springboot.app.Models.entities;

import java.io.Serializable;

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
@Table(name = "message")
public class Message implements Serializable{
	
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idMessage;
	    private String messageText;
	    
	    // @ManyToOne(cascade = {CascadeType.ALL})
		@ManyToOne
	    @JoinColumn(name="idBikeFk")
	    @JsonIgnoreProperties({"messages", "reservations"})
		// @JsonIgnoreProperties("messages")
	    private Bike bike;

	    @ManyToOne
	    @JoinColumn(name="IdClientFk")
	    @JsonIgnoreProperties({"messages","reservations"})
		// @JsonIgnoreProperties("messages")
	    private Client client;

		public Integer getIdMessage() {
			return idMessage;
		}

		public void setIdMessage(Integer idMessage) {
			this.idMessage = idMessage;
		}

		public String getMessageText() {
			return messageText;
		}

		public void setMessageText(String messageText) {
			this.messageText = messageText;
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
	
	    
	    

}
