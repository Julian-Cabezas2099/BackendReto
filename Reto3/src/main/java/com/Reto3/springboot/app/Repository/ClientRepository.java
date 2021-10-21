/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.springboot.app.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Reto3.springboot.app.CrudRepository.ClientCrudRepository;
import com.Reto3.springboot.app.Models.entities.Client;


@Repository
public class ClientRepository {
      @Autowired
    private ClientCrudRepository crud1;

    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }
    public Optional<Client> getCliente(int id){
        return crud1.findById(id);
    }

    public Client save(Client cliente){
        return crud1.save(cliente);
    }
    public void delete(Client cliente){
        crud1.delete(cliente);
    }
}
