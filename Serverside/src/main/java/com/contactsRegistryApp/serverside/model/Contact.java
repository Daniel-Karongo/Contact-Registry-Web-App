package com.contactsRegistryApp.serverside.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;

@Data
@Entity(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sn;

    private String fullName;
    private String phoneNumber;
    private String idNumber;
    private Date dateOfBirth;
    private String gender;
    private String countyOfResidence;
}

