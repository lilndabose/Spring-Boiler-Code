package com.in28minutes.rest.webservices.restfulwebservices.employee;

import com.in28minutes.rest.webservices.restfulwebservices.users.UserNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeJpaController {
    @Autowired
    EmployeeJpaRepository repository;

    @Autowired
    PostJpaRepository postRepository;

    @GetMapping("/v1/jpa/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    @GetMapping("/v1/jpa/employees/{id}")
    public Employee findOneEmployee(@PathVariable("id") long id){
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/v1/jpa/employees")
    public String saveEmployee(@RequestBody Employee emp){
        String str="User Saved Successfully";
        try{
            repository.save(emp);
        }catch(Exception e){
            str = e.getMessage();
        }

        return str;
    }

    @PutMapping("/v1/jpa/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id){
        String str = "User Updated Successfully !!!";
        Optional<Employee> emp1 = repository.findById(id);
        if(emp1.isPresent()){
            try{
                emp1.get().setName(employee.getName());
                emp1.get().setDob(employee.getDob());
                repository.save(emp1.get());
            }catch(Exception e){
                str = e.getMessage();
            }
        }
        return str;
    }

    @DeleteMapping("/v1/jpa/employees/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        String str = "User Deleted Successfully !!!";
        try{
            repository.deleteById(id);
        }catch(Exception e){
            str = e.getMessage();
        }

        return str;
    }

    // geting a particular users post
    @GetMapping("/v1/jpa/employees/{id}/posts")
    public List<Post> getAllUsersPosts(@PathVariable("id") long id){
        Optional<Employee> emp = repository.findById(id);
        if(!emp.isPresent())
               throw new UserNotFoundExceptions("id: "+id);

        return emp.get().getPosts();
    }

    // post to add an employee post
    @PostMapping("/v1/jpa/employees/{id}/post")
    public String addEmployeePost(@RequestBody Post post,@PathVariable("id") long id){
        String str = "Employee Post added successfully !!!";
        Optional<Employee> emp = repository.findById(id);
        if(!emp.isPresent())
            throw new UserNotFoundExceptions("id: "+id);
        try{
            post.setEmployee(emp.get());
            postRepository.save(post);
        }catch(Exception e){
            str = e.getMessage();
        }

        return str;
    }
}
