package com.example.demo.Controller;

import com.example.demo.Model.Score;
import com.example.demo.Service.ScoreService;
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
@RequestMapping ("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
   
    @GetMapping("/all")
   public List<Score> getAll(){
        return scoreService.getAll();
    }
   
   @GetMapping("/{id}")
   public Optional<Score> getScore(@PathVariable int id){
       return scoreService.getScore(id);
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Score save(@RequestBody Score score){
       return scoreService.save(score);
   }
   
    @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Score update (@RequestBody Score score){
       return scoreService.update(score);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean delete(@PathVariable int id){
       return scoreService.deleteScore(id);
   }
}
