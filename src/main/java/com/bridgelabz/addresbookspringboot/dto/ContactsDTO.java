package com.bridgelabz.addresbookspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not a Valid Name")
    private String name;
    private String city;
    private String state;
    private String address;
    private List<String> phoneNumber;
    private int zipCode;
    @Pattern(regexp = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$",message = "Not a Valid Email")
    private String email;
}
