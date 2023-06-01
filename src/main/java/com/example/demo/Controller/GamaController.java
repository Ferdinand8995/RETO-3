package com.example.demo.Controller;

import com.example.demo.Model.Gama;
import com.example.demo.Service.GamaService;
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
@RequestMapping ("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService gamaService;
   
    @GetMapping("/all")
   public List<Gama> getAll(){
        return gamaService.getAll();
    }
   
   @GetMapping("/{id}")
   public Optional<Gama> getGama(@PathVariable int id){
       return gamaService.getGama(id);
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Gama save(@RequestBody Gama gama){
       return gamaService.save(gama);
   }
   
    @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Gama update (@RequestBody Gama gama){
       return gamaService.update(gama);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean delete(@PathVariable int id){
       return gamaService.deleteGama(id);
   }
}
