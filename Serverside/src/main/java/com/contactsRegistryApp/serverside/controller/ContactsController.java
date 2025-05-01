package com.contactsRegistryApp.serverside.controller;

import com.contactsRegistryApp.serverside.model.Contact;
import com.contactsRegistryApp.serverside.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contacts")
//@CrossOrigin(origins = "*")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @GetMapping("")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return contactsService.getAllContacts();
    }

    @GetMapping("contact/{contactId}")
    public ResponseEntity<Optional<Contact>> getContact(@PathVariable("contactId") Integer id) {
        return contactsService.getContact(id);
    }

    @PostMapping("contact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        return contactsService.saveContact(contact);
    }

    @PatchMapping("contact")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        return contactsService.updateContact(contact);
    }

    @GetMapping("contacts/{gender}")
    public ResponseEntity<List<Contact>> searchContactsByGender(@PathVariable("gender") String gender) {
        return contactsService.searchContactsByGender(gender);
    }

    @GetMapping("contacts/{county}")
    public ResponseEntity<List<Contact>> searchContactsByCounty(@PathVariable("county") String county) {
        return contactsService.searchContactsByCounty(county);
    }

    @DeleteMapping("contact/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") Integer id) {
        return contactsService.deleteContact(id);
    }
}