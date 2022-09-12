package com.bridgelabz.addresbookspringboot.service;

import com.bridgelabz.addresbookspringboot.dto.ContactsDTO;
import com.bridgelabz.addresbookspringboot.model.Contact;

import java.util.List;

public interface AddressBookServiceInterface {

    Contact addContact(ContactsDTO contactsDTO);
    Contact editContact(ContactsDTO contactsDTO,int id);
    String deleteContact(int id);
    List<Contact> findByName(String name);
    Contact findById(int id);
    List<Contact> findByCity(String city);

    List<Contact> findAllContacts();
    List<Contact> findByState(String state);
}
