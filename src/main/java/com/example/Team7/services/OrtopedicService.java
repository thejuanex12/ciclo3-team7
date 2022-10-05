package com.example.Team7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Team7.entities.Orthesis;
import com.example.Team7.repositories.OrthesisRepository;


@Service
public class OrthesisService {
    
        @Autowired
        private OrthesisRepository orthesisRepository;

        public OrthesisService(OrthesisRepository orthesisRepository) {
            this.orthesisRepository = orthesisRepository;
        }

        // METODOS CRUD
        public List<Orthesis> getListOrthesis(){
            return this.orthesisRepository.findAll();
        }

        public Orthesis getOrthesis(int id){
            if(!this.orthesisRepository.findById(id).isEmpty()){
                return this.orthesisRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Orthesis crearOrthesis(Orthesis orthesis){
            return this.orthesisRepository.save(orthesis);
        }

        public void eliminarOrthesis(int id){
            if(!this.orthesisRepository.findById(id).isEmpty()){
                this.orthesisRepository.deleteById(id);
            }
        }

        public void actualizarOrthesis(int id, Orthesis orthesis){
            if(!this.orthesisRepository.findById(id).isEmpty()){
                Orthesis orthesisDB = this.orthesisRepository.findById(id).get();

                this.orthesisRepository.save(orthesisDB);
            }
        }
}
