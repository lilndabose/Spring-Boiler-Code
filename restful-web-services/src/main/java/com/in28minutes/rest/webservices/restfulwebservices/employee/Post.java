package com.in28minutes.rest.webservices.restfulwebservices.employee;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    private long id;

    private String description;

    //creating one to many relationship with Employee entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Employee employee;
}
