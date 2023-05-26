/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.Model.Car;
import com.example.demo.CrudRepository.CarCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;
    
    public List<Car> findall(){
        return (List<Car>)carCrudRepository.findAll();
    }
    
    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }
    
    public Car save(Car car){
        return carCrudRepository.save(car);
        }
    
    public void delete(Car car){
        carCrudRepository.delete(car);
    }
    
}
