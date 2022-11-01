package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// Filtering is used to decide which field to make appear or dissapear
// JsonProperty: is used to change the field name on api response
// JsonIgnore: used to hide a particular field statically on api response
// JsonIgnoreProperties: used to hide a field or list of fields on class level
// e.g: JsonIgnoreProperties("field1"), JsonIgnoreProperties({"field1","field2","field3"...fieldn }),


@JsonIgnoreProperties("tel")
public class Employee {
    @JsonProperty("username")
    private String name;
    private String tel;
    @JsonIgnore
    private String lastname;
}
