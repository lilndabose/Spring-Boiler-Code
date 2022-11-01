package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {
    @GetMapping("/v1/static-filtering")
    public Employee getEmployee(){
        return new Employee("Daniel","675234567","Ndabose");
    }
}
