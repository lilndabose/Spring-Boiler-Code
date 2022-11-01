package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFilteringController {
    @GetMapping("/v1/dynamic-filtering")
    public MappingJacksonValue getDynamicEmployee(){
        DynamicEmployee dynamicEmployee = new DynamicEmployee("Daniel","55197144","Ndabose");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","lastname");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicEmployeeFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicEmployee);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/v1/dynamic-filtering-list")
    public MappingJacksonValue getListDynamicEmployee(){
        List<DynamicEmployee> list = Arrays.asList(
                new DynamicEmployee("Daniel","6753987","Ndabose"),
                new DynamicEmployee("Junior","6753987","Malcom"),
                new DynamicEmployee("Max","6753987","Doumbe")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","lastname");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicEmployeeFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
