package com.cgnexus.example_19.service;

import com.cgnexus.example_19.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    public ContactService() {
        System.out.println("ContactService instance created");
    }

    /**
     * Save Contact Details into DB
     *
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}
