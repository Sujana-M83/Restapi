package com.example.d1ex4objectsending.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d1ex4objectsending.module.Address;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AddressController {
    @GetMapping("/path")
    public Address f1()
    {
        Address obj=new Address("ABI", "btech");
        return obj;
    }
    
}
