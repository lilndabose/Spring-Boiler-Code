package com.in28minutes.rest.webservices.restfulwebservices.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJpaRepository extends JpaRepository<Post,Long> {

}
