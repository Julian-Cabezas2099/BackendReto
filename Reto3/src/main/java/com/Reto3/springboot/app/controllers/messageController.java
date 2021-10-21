package com.Reto3.springboot.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Reto3.springboot.app.Models.entities.Message;
import com.Reto3.springboot.app.Services.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class messageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/all")
	public List<Message> getMessages() {
		return messageService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Message> getMessage(@PathVariable("id") int id) {
		return messageService.getMessage(id);
	}
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message m) {
		return messageService.save(m);
	}
	
	@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }
	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean delete(@PathVariable int id) {
        return messageService.deleteMessage(id);
    }
	
	/*private List <Integer> hola = new ArrayList<Integer>();
	
	
	@GetMapping("/ver")
	public List<Integer> ver() {
		hola.add(3);
		hola.add(2);
		hola.add(1);
		return hola;
	}*/
}
