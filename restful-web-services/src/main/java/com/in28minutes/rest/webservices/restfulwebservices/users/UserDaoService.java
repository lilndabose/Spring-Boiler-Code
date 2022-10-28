package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static List<Users> users = new ArrayList<>();
    static{
        users.add(new Users(1,"Daniel", LocalDate.now().minusYears(30)));
        users.add(new Users(2,"Royce", LocalDate.now().minusYears(21)));
        users.add(new Users(3,"Junior", LocalDate.now().minusYears(27)));
    }

    public List<Users> findAll(){
        return this.users;
    }

    public Users saveUser(Users user){
        this.users.add(user);
        return user;
    }

    public Users findOne(Integer id){
        Predicate<? super Users> predicate = user-> user.getId().equals(id);
        Users item = this.users.stream().filter(predicate).findFirst().orElse(null);
        if(item==null)
            throw new UserNotFoundExceptions("User with id: "+id+" is not found !!!");
        return item;
    }

    public List<Users> editOne(Users user){
        this.users.forEach(item->{
            if(item.getId().equals(user.getId())){
                item.setName((user.getName()));
                item.setDob(user.getDob());
            }
        });

        return this.users;
    }

    public void remove(Integer id){
        Predicate<? super Users> predicate = users -> users.getId().equals(id);

        if(!users.removeIf(predicate))
            throw new UserNotFoundExceptions("User with id: "+id+" is not found !!!");
    }
}
