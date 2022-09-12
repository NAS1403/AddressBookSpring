package com.bridgelabz.addresbookspringboot.model;

import com.bridgelabz.addresbookspringboot.dto.ContactsDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String city;
    private String state;
    private String address;
    @ElementCollection
    @CollectionTable(name = "phoneNumber", joinColumns = @JoinColumn(name = "id"))
    private List<String> phoneNumber;
    private int zipCode;
    private String email;

    public Contact(ContactsDTO contactsDTO) {
        this.name = contactsDTO.getName();
        this.city = contactsDTO.getCity();
        this.state = contactsDTO.getState();
        this.address = contactsDTO.getAddress();
        this.phoneNumber = contactsDTO.getPhoneNumber();
        this.zipCode = contactsDTO.getZipCode();
        this.email = contactsDTO.getEmail();
    }

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
