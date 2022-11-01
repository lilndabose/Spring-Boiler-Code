package com.in28minutes.rest.webservices.restfulwebservices.users;

import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "v1")
public class UsersController {
    private UserDaoService service = new UserDaoService();
    MessageSource messageSource;

    public UsersController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping("/users")
    public List<Users> retrieveAllUser(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Users> getOneUser(@PathVariable Integer id){
        Users users = service.findOne(id);
        EntityModel<Users> entityModel = EntityModel.of(users);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Users> addUser(@Valid @RequestBody Users users){
        Users usr = service.saveUser(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(users.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUsers(@PathVariable Integer id){
         service.remove(id);
    }

    @PatchMapping("/users/1")
    public List<Users> editUser(@RequestBody Users user){
        return service.editOne(user);
    }

    @GetMapping("/hello")
    public String greet(){
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }


}
