package com.stanley.rest.ws.restfuldemo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
    
    @Autowired
    private MessageSource messageSource;
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
    // Method - "hello-world"
    @GetMapping( path= "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVar(@PathVariable String name) {
        return new HelloWorldBean(String.format("Welcome to  %s world", name));
    }
    
// // GET 
//    // URI/path - /hello-world-internationalized
//    // Method - "helloWorldInternationalized"
//    @GetMapping( path= "/hello-world-internationalized")
//    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//        return messageSource.getMessage("good.morning.message", null, locale);
//    }
    
    // GET 
    // URI/path - /hello-world-internationalized
    // Method - "helloWorldInternationalized"
    @GetMapping( path= "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
