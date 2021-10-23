package com.Reto3.springboot.app.Services;

import java.util.List;
import java.util.Optional;

import com.Reto3.springboot.app.Models.entities.Admin;
import com.Reto3.springboot.app.Repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository metodosCrudAdmin;

    public List<Admin> getAll() {
        return metodosCrudAdmin.getAll();
    }

    public Optional<Admin> getAdmin(int adminId) {
        return metodosCrudAdmin.getAdmin(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getId() == null) {
            return metodosCrudAdmin.save(admin);
        } else {
            Optional<Admin> e = metodosCrudAdmin.getAdmin(admin.getId());
            if (e == null) {
                return metodosCrudAdmin.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin) {
        if (admin.getId() != null) {
            Optional<Admin> e = metodosCrudAdmin.getAdmin(admin.getId());
            if (e != null) {
                if (admin.getName() != null) {
                    e.get().setName(admin.getName());
                }
                if (admin.getPassword() != null) {
                    e.get().setPassword(admin.getPassword());
                }
                metodosCrudAdmin.save(e.get());
                return e.get();
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean deleteAdmin(int adminId) {
        Boolean respuesta = getAdmin(adminId).map(admin -> {
            metodosCrudAdmin.delete(admin);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
