package abi.demo.cotroller;

import org.springframework.web.bind.annotation.RestController;

import abi.demo.module.Address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AddressController {
    @GetMapping("/abi1")
    public Address getAddress(){
        Address obj=new Address("abilesh", 19);
        return obj;
    }
    
}
