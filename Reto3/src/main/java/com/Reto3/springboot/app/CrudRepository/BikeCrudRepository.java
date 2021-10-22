package com.Reto3.springboot.app.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.Reto3.springboot.app.Models.entities.Bike;

public interface BikeCrudRepository extends CrudRepository<Bike,Integer>{
    
}

