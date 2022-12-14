package com.example.Team7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Team7.entities.Category;
import com.example.Team7.repositories.CategoryRepository;


@Service
public class CategoryService {
    
        @Autowired
        private CategoryRepository categoryRepository;

        public CategoryService(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        // METODOS CRUD
        public List<Category> getListCategorys(){
            return this.categoryRepository.findAll();
        }

        public Category getCategory(int id){
            if(!this.categoryRepository.findById(id).isEmpty()){
                return this.categoryRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Category crearCategory(Category category){
            return this.categoryRepository.save(category);
        }

        public void eliminarCategory(int id){
            if(!this.categoryRepository.findById(id).isEmpty()){
                this.categoryRepository.deleteById(id);
            }
        }

        public void actualizarCategory(int id, Category category){
            if(!this.categoryRepository.findById(id).isEmpty()){
                Category categoryDB = this.categoryRepository.findById(id).get();

                this.categoryRepository.save(categoryDB);
            }
        }
}
