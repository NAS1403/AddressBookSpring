package com.bridgelabz.addresbookspringboot.service;

import com.bridgelabz.addresbookspringboot.dto.ContactsDTO;
import com.bridgelabz.addresbookspringboot.email.EmailService;
import com.bridgelabz.addresbookspringboot.exception.CustomException;
import com.bridgelabz.addresbookspringboot.model.Contact;
import com.bridgelabz.addresbookspringboot.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements AddressBookServiceInterface{

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    EmailService emailService;

    @Override
    public Contact addContact(ContactsDTO contactsDTO) {
        Contact contact = new Contact(contactsDTO);
        emailService.sendEmail(contactsDTO.getEmail(),"Employee added","Hello "+contactsDTO.getName()+" your employee record was added successfully");
       return addressBookRepository.save(contact);
    }

    @Override
    public Contact editContact(ContactsDTO contactsDTO, int id) {
        if(addressBookRepository.findById(id).isPresent()) {
            Contact contact = addressBookRepository.getContactById(id);
            contact.setName(contactsDTO.getName());
            contact.setCity(contactsDTO.getCity());
            contact.setState(contactsDTO.getState());
            contact.setPhoneNumber(contactsDTO.getPhoneNumber());
            contact.setAddress(contactsDTO.getAddress());
            contact.setEmail(contactsDTO.getEmail());
            contact.setZipCode(contactsDTO.getZipCode());
            return addressBookRepository.save(contact);
        }
        else{
            throw new CustomException("Contact by ID "+id+" is not present");
        }
    }

    @Override
    public String deleteContact(int id) {
        if(addressBookRepository.findById(id).isPresent()) {
            addressBookRepository.deleteById(id);
            return "Delete Successful";
        }else{
            throw new CustomException("Contact by ID "+id+" is not present");
        }
    }

    @Override
    public List<Contact> findByName(String name) {
        if(!addressBookRepository.findContactByName(name).isEmpty()){
           return addressBookRepository.findContactByName(name);
        }else{
            throw new CustomException("No contact with "+ name+" found!!!" );
        }
    }

    @Override
    public Contact findById(int id) {
        if(addressBookRepository.findById(id).isPresent()){
            return addressBookRepository.getContactById(id);
        }else{
            throw new CustomException("No contact with "+ id+" found!!!" );
        }
    }

    @Override
    public List<Contact> findByCity(String city) {
        if(!addressBookRepository.findContactByCity(city).isEmpty()){
            return addressBookRepository.findContactByCity(city);
        }else{
            throw new CustomException("No contact with "+ city+" found!!!" );
        }
    }

    @Override
    public List<Contact> findByState(String state) {
        if(!addressBookRepository.findContactByState(state).isEmpty()){
            return addressBookRepository.findContactByState(state);
        }else{
            throw new CustomException("No contact with "+ state+" found!!!" );
        }
    }


    @Override
    public List<Contact> findAllContacts() {
        if(!addressBookRepository.findAll().isEmpty()){
            return addressBookRepository.findAll();
        }
        else{
            throw new CustomException("No contact in database found!!!" );
        }
    }
}
