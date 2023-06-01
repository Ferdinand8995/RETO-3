package com.example.demo.Controller;

import com.example.demo.Model.Reservation;
import com.example.demo.Service.ReservationService;
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
@RequestMapping ("/api/Reservation")
public class ReservationController {
     @Autowired
    private ReservationService reservationService;
   
    @GetMapping("/all")
   public List<Reservation> getAll(){
        return reservationService.getAll();
    }
   
   @GetMapping("/{id}")
   public Optional<Reservation> getReservation(@PathVariable int id){
       return reservationService.getReservation(id);
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation save(@RequestBody Reservation reservation){
       return reservationService.save(reservation);
   }
   
    @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation update (@RequestBody Reservation reservation){
       return reservationService.update(reservation);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean delete(@PathVariable int id){
       return reservationService.deleteReservation(id);
   }
     
}
