package com.Reto3.springboot.app.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.Reto3.springboot.app.Models.entities.Client;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>{

}
