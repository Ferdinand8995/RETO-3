package com.example.demo.Controller;

import com.example.demo.Model.Message;
import com.example.demo.Service.MessageService;
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
@RequestMapping ("/api/Message")
public class MessageController {
        @Autowired
    private MessageService messageService;
   
    @GetMapping("/all")
   public List<Message> getAll(){
        return messageService.getAll();
    }
   
   @GetMapping("/{id}")
   public Optional<Message> getMessage(@PathVariable int id){
       return messageService.getMessage(id);
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Message save(@RequestBody Message message){
       return messageService.save(message);
   }
   
    @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Message update (@RequestBody Message message){
       return messageService.update(message);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean delete(@PathVariable int id){
       return messageService.deleteMessage(id);
   }
}
