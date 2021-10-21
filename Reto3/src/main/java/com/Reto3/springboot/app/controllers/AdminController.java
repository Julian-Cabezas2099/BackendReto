package com.Reto3.springboot.app.controllers;

import java.util.List;
import java.util.Optional;

import com.Reto3.springboot.app.Models.entities.Admin;
import com.Reto3.springboot.app.Services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AdminController {

    @Autowired
    private AdminService serviceAdmin;

    @GetMapping("/all")
    public List<Admin> getAdmins() {
        return serviceAdmin.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int AdminId) {
        return serviceAdmin.getAdmin(AdminId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin Admin) {
        return serviceAdmin.save(Admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin Admin) {
        return serviceAdmin.update(Admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int AdminId) {
        return serviceAdmin.deleteAdmin(AdminId);
    }

}
