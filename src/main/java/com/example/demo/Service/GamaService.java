/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Model.Gama;
import com.example.demo.repository.GamaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;
    
        public List<Gama> getAll(){
        return gamaRepository.findAll();
    }

    public Optional<Gama> getGama (int id) {
        return gamaRepository.getGama(id);
    }
     
  public Gama save(Gama gama){
      if(gama.getIdGama()==null){
          return gamaRepository.save(gama);
      }else{
          Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
          if(gamaEncontrado.isEmpty()){
              return gamaRepository.save(gama);
           }else{
                return gama;
          }
        }
        
    }
  
  public Gama update (Gama gama){
      if (gama.getIdGama()!=null){
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
                if(gamaEncontrado.isPresent()){
                                
                                if (gama.getName()!=null){
                                                        gamaEncontrado.get().setName(gama.getName());
                                                        }
                                if(gama.getDescription()!=null){
                                                        gamaEncontrado.get().setDescription(gama.getDescription());
                                                        }
                                
                              
                                                     return gamaRepository.save(gamaEncontrado.get());
                                              }     
                                                else{
                                                     return gama;
                                                      }              
                                }
                                    else{
                                      return gama;
                                       }

    }
                            public boolean deleteGama(int id){
                            boolean respuesta = getGama(id).map(gama -> {
                              gamaRepository.delete(gama);
                              return true;
                              }).orElse(false);
                              return respuesta;
                            }  
}


