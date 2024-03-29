/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.Model.Gama;
import com.example.demo.CrudRepository.GamaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GamaRepository {
    @Autowired
    private GamaCrudRepository gamaCrudRepository;
    
    public List<Gama> findAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }
    
    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }
    
    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
    
}
