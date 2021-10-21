package com.Reto3.springboot.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Reto3.springboot.app.CrudRepository.MessageCrudRepository;
import com.Reto3.springboot.app.Models.entities.Message;

@Repository
public class MessageRepository {

	@Autowired
	private MessageCrudRepository messageCrud;
	
	public List<Message> getAll(){
		return (List<Message>) messageCrud.findAll();
	}
	
	public Optional<Message> getMessage(int id){
		return messageCrud.findById(id);
	}
	
	public Message save(Message men) {
		
		return messageCrud.save(men);
		
	}
	 public void delete(Message message){
	        messageCrud.delete(message);
	    }
}
