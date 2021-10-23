package com.Reto3.springboot.app.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Reto3.springboot.app.Models.entities.Message;
import com.Reto3.springboot.app.Repository.MessageRepository;

@Service
public class MessageService{
	@Autowired
	private MessageRepository messageRepository;
	
	
	public List<Message> getAll(){
		return messageRepository.getAll();
	}
	
	public Optional<Message> getMessage(int id){
		return messageRepository.getMessage(id);
	}
	
	
	public Message save (Message m) {
		if (m.getIdMessage()==null) {
			return messageRepository.save(m);
		}else {
			Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
			if (maux == null) {
				return messageRepository.save(m);
			}else {
				return m;
			}
		}
	}
	
	public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(e != null){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
        	messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
	
	
}
