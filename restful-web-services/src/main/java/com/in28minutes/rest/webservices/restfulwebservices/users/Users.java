package com.in28minutes.rest.webservices.restfulwebservices.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

    private Integer id;

    @Size(min=5,message="Name should contain atleast 5 characters")
    private String name;

    @Past(message = "Dob should be in the past !!!")
    private LocalDate dob;
}
