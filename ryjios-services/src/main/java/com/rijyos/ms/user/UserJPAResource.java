package com.rijyos.ms.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rijyos.ms.user.exception.UserNotFoundException;

@RestController
public class UserJPAResource {

    @Autowired(required = true)
    private UserRepository userRepository;

    @GetMapping(path = "/rjam/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/rjam/users/{id}")
    public User retrieveUser(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        return user.get();
//        return resource;

    }

    @DeleteMapping(path = "/rjam/users/{id}")
    public void deleteUser(@PathVariable int id) {

        userRepository.deleteById(id);

    }

    @PostMapping(path = "/rjam/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        System.out.println("before creating user = " + user);
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/rjam/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/rjam/users/{emailId}/loginValidate/{password}")
    public User loginValidate(@PathVariable String emailId, @PathVariable String password) {
        Optional<User> existingUser = userRepository.findByUserEmailId(emailId);
        if (!existingUser.isPresent()) {
            throw new UserNotFoundException("emailId-" + emailId);
        }
        User user = existingUser.get();
        if (!password.equals(user.getUserPassword())) {
            throw new UserNotFoundException("invalid credentials");
        }

        return user;
    }

}
