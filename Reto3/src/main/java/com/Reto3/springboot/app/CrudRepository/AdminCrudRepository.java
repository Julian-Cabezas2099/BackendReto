package com.Reto3.springboot.app.CrudRepository;

import com.Reto3.springboot.app.Models.entities.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {

}
