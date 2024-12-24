package com.cgnexus.example_19.service;

import com.cgnexus.example_19.constants.CgnexusConstants;
import com.cgnexus.example_19.model.Contact;
import com.cgnexus.example_19.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Contact result = contactRepository.save(contact);

        if (result.getContactId() > 0) {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMessagesWithOpenStatus() {
        return contactRepository.findMessagesWithOpenStatus(CgnexusConstants.OPEN);
    }

    public boolean updateStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);

        contact.ifPresent(contact1 -> {
            contact1.setStatus(CgnexusConstants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });

        Contact updatedContact = contactRepository.save(contact.get());

        if (updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;

    }
}
