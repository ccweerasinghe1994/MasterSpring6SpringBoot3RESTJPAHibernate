package com.cgnexus.example_19.repository;

import com.cgnexus.example_19.model.Person;
import com.cgnexus.example_19.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Roles getByRoles(Roles roles);
}
