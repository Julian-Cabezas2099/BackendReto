package com.Reto3.springboot.app.CrudRepository;

import org.springframework.data.repository.CrudRepository;


import com.Reto3.springboot.app.Models.entities.Message;


public interface MessageCrudRepository extends CrudRepository<Message, Integer>{

}
