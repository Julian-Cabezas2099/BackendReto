package com.Reto3.springboot.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reto3.springboot.app.Models.entities.Category;
import com.Reto3.springboot.app.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getALL(){
        return categoryRepository.getALL();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(p.getId());
            if (paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public boolean deleteCategory(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
