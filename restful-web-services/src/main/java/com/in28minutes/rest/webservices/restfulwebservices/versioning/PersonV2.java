package com.in28minutes.rest.webservices.restfulwebservices.versioning;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonV2 {
    private Name name;
    public PersonV2(Name name){
        this.name = name;
    }
}
