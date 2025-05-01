package com.contactsRegistryApp.serverside.repository;

import com.contactsRegistryApp.serverside.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByGender(String gender);

    List<Contact> findByCountyOfResidence(String county);
}
