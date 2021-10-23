package com.Reto3.springboot.app.Models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bike")
/**
 * Clase Bike representacion de la tabla bike en la BD
 */
public class Bike implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * atributo id
     */
    private Integer id;
    /**
     * atributo nombre
     */
    private String name;
    /**
     * atributo brand
     */
    private String brand;
    /**
     * atributo año o modelo
     */
    private Integer year;
    /**
     * atributo descripcion
     */
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryIdFk")
    @JsonIgnoreProperties("bikes")
    /**
     * atributo objeto Categoria
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bike")
    // @JsonIgnoreProperties("bike")
    @JsonIgnoreProperties({"bike","client"})
    /**
     *  atributo lista de mensajes
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike","client"})
    /**
     * atributo lista de reservaciones
     */
    private List<Reservation> reservations;
    /**
     * método get identficador
     */
    public Integer getId() {
        return id;
    }
    /**
     * método set identficador
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * método get marca
     */
    public String getBrand() {
        return brand;
    }
    /**
     * método set marca
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * método get modelo
     */
    public Integer getYear() {
        return year;
    }
    /**
     * método set modelo
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * método get nombre
     */
    public String getName() {
        return name;
    }
    /**
     *  método set nombre
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * método get categoria
     */
    public Category getCategory() {
        return category;
    }
    /**
     * método set categoria
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * método set descripcion
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * método get descripcion
     */
    public String getDescription() {
        return description;
    }
    /**
     * método get mensajes
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * método set mensajes
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * método get reservaciones
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * método set reservaciones
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}

