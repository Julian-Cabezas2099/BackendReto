package com.Reto3.springboot.app.Services;

import java.util.List;
import java.util.Optional;

import com.Reto3.springboot.app.Models.entities.Bike;
import com.Reto3.springboot.app.Repository.BikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int id){
        return bikeRepository.getBike(id);
    }

    public Bike save(Bike p){
        if(p.getId()==null){
            return bikeRepository.save(p);
        }else{
            Optional<Bike> paux=bikeRepository.getBike(p.getId());
            if (paux == null){
                return bikeRepository.save(p);
            }else{
                return p;
            }
        }
    }
    public Bike update(Bike Bike){
        if(Bike.getId()!=null){
            Optional<Bike> e= bikeRepository.getBike(Bike.getId());
            if(e != null){
                if(Bike.getName()!=null){
                    e.get().setName(Bike.getName());
                }
                if(Bike.getBrand()!=null){
                    e.get().setBrand(Bike.getBrand());
                }
                if(Bike.getYear()!=null){
                    e.get().setYear(Bike.getYear());
                }
                if(Bike.getDescription()!=null){
                    e.get().setDescription(Bike.getDescription());
                }
                if(Bike.getCategory()!=null){
                    e.get().setCategory(Bike.getCategory());
                }

                bikeRepository.save(e.get());
                return e.get();
            }else{
                return Bike;
            }
        }else{
            return Bike;
        }
    }

    public Optional<Bike> getBikes(int id) {
        return bikeRepository.getBike(id);
    }

    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getBike(bikeId).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

