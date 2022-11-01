package com.in28minutes.rest.webservices.restfulwebservices.users;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    // @JsonProperty used to chanhe the field name in json response
    @JsonProperty("username")
    private String name;

    @Past(message = "Dob should be in the past !!!")
    @JsonProperty("birthday")
    private LocalDate dob;
}
