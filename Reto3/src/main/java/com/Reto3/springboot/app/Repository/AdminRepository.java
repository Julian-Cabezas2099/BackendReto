package com.Reto3.springboot.app.Repository;

import com.Reto3.springboot.app.CrudRepository.AdminCrudRepository;
import com.Reto3.springboot.app.Models.entities.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository repoAdmin;

    public List<Admin> getAll() {
        return (List<Admin>) repoAdmin.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return repoAdmin.findById(id);
    }

    public Admin save(Admin admin) {
        return repoAdmin.save(admin);
    }

    public void delete(Admin admin) {
        repoAdmin.delete(admin);
    }

}
