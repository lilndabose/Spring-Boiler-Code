package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //    JSON format of name for api v1
//    {
//        name: "Bob charlie"
//    }
    @GetMapping("/v1/person")
    public PersonV1 getPersonv1() {
        return new PersonV1("Bob Charlie");
    }

    //    JSON format of name for api v1
//    {
//        name: {
//                firstName:"Bob",
//                lastName:"Charlie"
//            }
//    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonv2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
