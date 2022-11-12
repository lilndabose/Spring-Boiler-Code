package com.in28minutes.rest.webservices.restfulwebservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employee/{id}")
    public Employee getOneEmployee(@PathVariable("id") long id){
        return repository.findOneEmployee(id);
    }

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody Employee emp){
        repository.saveEmployee(emp);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        String res = "Failed in deleted user";
        if(repository.deleteEmployee(id)){
            res = "Users Deleted successfully";
        }

        return res;
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody Employee emp, @PathVariable("id") long id){
        repository.updateEmployee(emp,id);
    }
}
