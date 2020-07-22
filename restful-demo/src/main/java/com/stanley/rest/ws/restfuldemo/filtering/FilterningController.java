package com.stanley.rest.ws.restfuldemo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterningController {
    
//    @GetMapping(path="/filtering")
//    public SomeBean getSomeBean() {
//        return new SomeBean("value1", "value2", "value3");
//    }
    
    @GetMapping(path="/filtering")
    public MappingJacksonValue getSomeBean() {
        SomeBean someBean =  new SomeBean("value1", "value2", "value3");
        
        SimpleBeanPropertyFilter someFilter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleBeanFilter", someFilter);
        
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        return mapping;
    }
    
    @GetMapping(path="/filtering-list")
    public MappingJacksonValue getSomeBeanList() {
        List<SomeBean>  someBeanList  =  Arrays.asList( new SomeBean("value1", "value2", "value3"), new SomeBean("field1", "field2", "field3"));
        
        SimpleBeanPropertyFilter someFilter =  SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SimpleBeanFilter", someFilter);
        
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filters);
        return mapping;
    }

}
