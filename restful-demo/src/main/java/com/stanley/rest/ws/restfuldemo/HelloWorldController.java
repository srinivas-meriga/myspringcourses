package com.stanley.rest.ws.restfuldemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
    
    // GET 
    // URI/path - hello-world
    // Method - "hello-word"
    
    // @RequestMapping (method = RequestMethod.GET, path= "/hellow-world" ) or
    @GetMapping( path= "/hello-world")
    public String helloWorld() {
        return "Hello world";
    }
    
 // GET 
    // URI/path - hello-world-bean
    // Method - "hello-word"
    @GetMapping( path= "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }
    
 // GET 
    // URI/path - /hello-world-bean/path-variable/stanley
    // Method - "hello-word"
    @GetMapping( path= "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVar(@PathVariable String name) {
        return new HelloWorldBean(String.format("Welcome to  %s world", name));
    }

}
