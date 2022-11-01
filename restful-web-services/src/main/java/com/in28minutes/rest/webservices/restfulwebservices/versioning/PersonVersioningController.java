package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    /*JSON format of name for api v1
    {
       name: "Bob charlie"
    }*/
    @GetMapping("/v1/person")
    public PersonV1 getPersonv1() {
        return new PersonV1("Bob Charlie");
    }

    /*JSON format of name for api v1
    {
         name: {
            firstName:"Bob",
            lastName:"Charlie"
        }
    }*/

    @GetMapping("/v2/person")
    public PersonV2 getPersonv2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    // ----- We can also achieve it using request params -----
    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 getPersonv1RequestParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 getPersonv2RequestParam(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    // ----- We can also achieve it using X-API-VERSION -----
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getPersonv1Header() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getPersonv2Header(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    // ----- We can also achieve it using Accept and meta data-----
    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonv1HeaderAccept() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonv2HeaderAccept(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

}
