package com.cgnexus.example_19.service;

import com.cgnexus.example_19.constants.CgnexusConstants;
import com.cgnexus.example_19.model.Person;
import com.cgnexus.example_19.model.Roles;
import com.cgnexus.example_19.repository.PersonRepository;
import com.cgnexus.example_19.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;


    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(CgnexusConstants.STUDENT_ROLE);
        person.setRoles(role);
        Person savedPerson = personRepository.save(person);
        if (null != savedPerson && savedPerson.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
