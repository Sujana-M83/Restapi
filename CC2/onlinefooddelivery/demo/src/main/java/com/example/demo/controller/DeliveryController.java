package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Delivery;
import com.example.demo.service.DeliveryService;
@RestController
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @PostMapping("/api/delivery")
    public Delivery addDelivery(@RequestBody Delivery delivery)
    {
        return deliveryService.addDelivery(delivery);
    }
    @GetMapping("/api/delivery")
    public List<Delivery> getDelivery()
    {
        return deliveryService.getDelivery();
    }
    @GetMapping("api/delivery/{Userid}")
    public Optional<Delivery> getDeliveryById(@PathVariable Long Userid)
    {
        return deliveryService.getDeliveryById(Userid);
    }
    @PutMapping("/api/delivery/{Userid}")
    public Delivery edituser(@PathVariable Long Userid, @RequestBody Delivery delivery) {
        
        
        return deliveryService.edituser(Userid,delivery);
    }

    @DeleteMapping("/api/delivery/{Userid}")
    public void deluser(@PathVariable Long Userid)
    {
        deliveryService.deluser(Userid);
    }
    @GetMapping("/pathh6/{offset}/{pagesize}")
    public List<Delivery> getpage(@PathVariable int offset,@PathVariable int pagesize)
    {
        return deliveryService.page(pagesize,offset);
    }
    @GetMapping("/pathh7/{field}")
    public List<Delivery> getsort(@PathVariable String field)
    {
        return deliveryService.sort(field);
    }
    @GetMapping("/pathh8/{pageNumber}/{pageSize}/{field}")
    public List<Delivery> getpagesort(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String field)
    {
        return deliveryService.getpagesort(pageNumber,pageSize,field);
    }
}