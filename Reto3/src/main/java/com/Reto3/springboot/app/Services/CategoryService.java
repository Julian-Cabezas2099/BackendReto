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
            if (paux == null){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
    public Category update(Category Category){
        if(Category.getId()!=null){
            Optional<Category> e= categoryRepository.getCategory(Category.getId());
            if(e != null){
                if(Category.getName()!=null){
                    e.get().setName(Category.getName());
                }
                if(Category.getDescription()!=null){
                    e.get().setDescription(Category.getDescription());
                }
                categoryRepository.save(e.get());
                return e.get();
            }else{
                return Category;
            }
        }else{
            return Category;
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
