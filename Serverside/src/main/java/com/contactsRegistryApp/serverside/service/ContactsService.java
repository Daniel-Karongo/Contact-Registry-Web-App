package com.contactsRegistryApp.serverside.service;

import com.contactsRegistryApp.serverside.model.Contact;
import com.contactsRegistryApp.serverside.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    public ResponseEntity<List<Contact>> getAllContacts() {
        try {
            List<Contact> contacts = contactsRepository.findAll();
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<Contact>> getContact(Integer id) {
        try {
            Optional<Contact> contact = contactsRepository.findById(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Contact> saveContact(Contact contact) {
        try {
            Contact savedContact = contactsRepository.save(contact);
            return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Contact> updateContact(Contact contact) {
        try {
            Contact savedContact = contactsRepository.save(contact);
            return new ResponseEntity<>(savedContact, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Contact>> searchContactsByGender(String gender) {
        try {
            List<Contact> genderContacts = contactsRepository.findByGender(gender);
            return new ResponseEntity<>(genderContacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Contact>> searchContactsByCounty(String county) {
        try {
            List<Contact> countyContacts = contactsRepository.findByCountyOfResidence(county);
            return new ResponseEntity<>(countyContacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteContact(Integer id) {
        try {
            contactsRepository.deleteById(id);
            return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete contact", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
