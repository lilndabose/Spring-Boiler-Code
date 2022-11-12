package com.in28minutes.rest.webservices.restfulwebservices.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void saveEmployee(Employee employee){
        entityManager.merge(employee);
    }


    public Employee findOneEmployee(long id){
       return entityManager.find(Employee.class,id);
    }

    public boolean deleteEmployee(long id){
        boolean result = false;
        Employee emp = new Employee();
        emp = entityManager.find(Employee.class,id);
        if(!emp.getName().isEmpty())
            entityManager.remove(emp);
            result = true;

        return result;
    }

    public void updateEmployee(Employee employee,long id){
        Employee emp = new Employee();
        emp = entityManager.find(Employee.class,id);
        emp.setDob(employee.getDob());
        employee.setName(employee.getName());

        entityManager.merge(emp);
    }
}
