package com.cgnexus.example_19.service;

import com.cgnexus.example_19.constants.CgnexusConstants;
import com.cgnexus.example_19.model.Contact;
import com.cgnexus.example_19.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Save Contact Details into DB
     *
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(CgnexusConstants.OPEN);
        contact.setCreatedBy(CgnexusConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMessage(contact);

        if (result > 0) {
            isSaved = true;
        }
        
        return isSaved;
    }

}
