package com.Reto3.springboot.app.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.Reto3.springboot.app.CrudRepository.CategoryCrudRepository;
import com.Reto3.springboot.app.Models.entities.Category;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository CategoryCrud;

    public List<Category> getALL(){
        return (List<Category>) CategoryCrud.findAll();
    }

    public Optional<Category> getCategory(int id){
        return CategoryCrud.findById(id);
    }

    public Category save(Category p){
        return CategoryCrud.save(p);
    }

    public void delete(Category category){
        CategoryCrud.delete(category);
    }
    
}
