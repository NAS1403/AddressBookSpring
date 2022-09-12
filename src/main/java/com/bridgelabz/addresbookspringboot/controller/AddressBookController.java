package com.bridgelabz.addresbookspringboot.controller;

import com.bridgelabz.addresbookspringboot.dto.ContactsDTO;
import com.bridgelabz.addresbookspringboot.dto.ResponseDTO;
import com.bridgelabz.addresbookspringboot.service.AddressBookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class AddressBookController {

    @Autowired
    AddressBookServiceInterface addressBookService;

    @PostMapping("/addContact")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactsDTO contactsDTO){
        ResponseDTO responseDTO = new ResponseDTO("Added",addressBookService.addContact(contactsDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/editContact/{id}")
    public ResponseEntity<ResponseDTO> editContact(@Valid @RequestBody ContactsDTO contactsDTO, @PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Edited",addressBookService.editContact(contactsDTO,id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContactById/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted",addressBookService.deleteContact(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContactByName")
    public ResponseEntity<ResponseDTO> findContactByName(@RequestParam(value = "name") String name){
        ResponseDTO responseDTO = new ResponseDTO("Retrieved",addressBookService.findByName(name));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContactById")
    public ResponseEntity<ResponseDTO> findContactById(@RequestParam(value = "id") int id){
        ResponseDTO responseDTO = new ResponseDTO("Retrieved",addressBookService.findById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContactByCity")
    public ResponseEntity<ResponseDTO> findContactByCity(@RequestParam(value = "city") String city){
        ResponseDTO responseDTO = new ResponseDTO("Retrieved",addressBookService.findByCity(city));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllContacts")
    public ResponseEntity<ResponseDTO> findAllContacts(){
        ResponseDTO responseDTO = new ResponseDTO("Retrieved",addressBookService.findAllContacts());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContactByState")
    public ResponseEntity<ResponseDTO> findContactByState(@RequestParam(value = "state") String state){
        ResponseDTO responseDTO = new ResponseDTO("Retrieved",addressBookService.findByState(state));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
