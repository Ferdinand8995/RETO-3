/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping ("/api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
   
    @GetMapping("/all")
   public List<Client> getAll(){
        return clientService.getAll();
    }
   
    
    @GetMapping("/{id}")
   public Optional<Client> getClient(@PathVariable int id){
       return clientService.getClient(id);
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Client save(@RequestBody Client client){
       return clientService.save(client);
   }
   
    @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Client update (@RequestBody Client client){
       return clientService.update(client);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean delete(@PathVariable int id){
       return clientService.deleteClient(id);
   }
     
}

