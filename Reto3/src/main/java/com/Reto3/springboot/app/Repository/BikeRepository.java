package com.Reto3.springboot.app.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.Reto3.springboot.app.CrudRepository.BikeCrudRepository;
import com.Reto3.springboot.app.Models.entities.Bike;
import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {
    
    @Autowired
    private BikeCrudRepository BikeCrud;

    public List<Bike> getAll(){
        return (List<Bike>) BikeCrud.findAll();
    }

    public Optional<Bike> getBike(int id){
        return BikeCrud.findById(id);
    }

    public Bike save(Bike p){
        return BikeCrud.save(p);
    }

    public void delete(Bike bike){
        BikeCrud.delete(bike);
    }
    
}
