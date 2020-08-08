package com.rijyos.ms.user;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rijyos.ms.user.exception.UserNotFoundException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserJPAResource {

    @Autowired(required = true)
    private UserRepository userRepository;

    @GetMapping(path = "/rjam/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/rjam/users/{userId}")
    public User retrieveUser(@PathVariable String userId) {

        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("userId-" + userId);
        }

        return user.get();
//        return resource;

    }

    @DeleteMapping(path = "/rjam/users/{userId}")
    public void deleteUser(@PathVariable String userId) {

        userRepository.deleteById(userId);

    }

    @PostMapping(path = "/rjam/users")
    public User createUser(@Valid @RequestBody User user) {
        System.out.println("before creating user = " + user);
        user.setRegestiredDate(new Timestamp(System.currentTimeMillis()));
        User savedUser = userRepository.save(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUser.getUserId())
//                .toUri();
        return savedUser;
    }

    @PostMapping(path = "/rjam/users/{userId}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable String userId) {

        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setUserId(userId);
        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
                .buildAndExpand(user.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/rjam/users/loginValidate")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request (Validation error)"),
            @ApiResponse(code = 404, message = "Source Price List not found") })
    public User loginValidate(@RequestBody User user) {
        String emailId = user.getUserEmailId();
        String password = user.getUserPassword();
        Optional<User> optionalUser = userRepository.findByUserEmailId(emailId);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("emailId-" + emailId);
        }
        User existingUser = optionalUser.get();
        if (!password.equals(existingUser.getUserPassword())) {
            throw new UserNotFoundException("invalid credentials");
        }

        return existingUser;
    }

}
