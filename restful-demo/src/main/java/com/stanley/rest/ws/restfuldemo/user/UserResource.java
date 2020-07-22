package com.stanley.rest.ws.restfuldemo.user;



import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stanley.rest.ws.restfuldemo.user.exception.UserNotFoundException;


@RestController
public class UserResource {

    @Autowired(required = true)
    private UserDAOService userService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    
    public User retrieveUser(@PathVariable int id) {
     
        User user = userService.findOne(id);
     
        if (user== null) {
     
            throw new UserNotFoundException("id-" + id);}
        
        
     
        EntityModel<User> model = new EntityModel<>(user);
     
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
     
        model.add(linkTo.withRel("all-users"));
     
        return user;
     
    }
    
    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        
        User user =  userService.deleteById(id);
        if(null == user) {
            throw new UserNotFoundException ("id = " + id);            
        }
        
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
