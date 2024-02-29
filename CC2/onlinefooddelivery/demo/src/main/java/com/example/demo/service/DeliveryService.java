package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Delivery;

import com.example.demo.repository.DeliveryRepo;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepo deliveryRepo;
    //post
    public Delivery addDelivery(Delivery delivery)
    {
        return deliveryRepo.save(delivery);
    }
    //get
    public List<Delivery> getDelivery()
    {
        return deliveryRepo.findAll();
    }
    //getbyid
    public Optional<Delivery> getDeliveryById(long Userid)
    {
        return deliveryRepo.findById(Userid);
    }
    //put
    public Delivery edituser(Long Userid,Delivery delivery)
    {
        Delivery DeliveryAvail = deliveryRepo.findById(Userid).orElse(null);
        if(DeliveryAvail !=null)
        {    
              DeliveryAvail.setEmailId(delivery.getEmailId());
              DeliveryAvail.setUserName(delivery.getUserName());
              DeliveryAvail.setPassword(delivery.getPassword());
              DeliveryAvail.setConfirmPassword(delivery.getConfirmPassword());
             return deliveryRepo.saveAndFlush(DeliveryAvail);
        }
        else
        return null;
    }
    //delete

    public void deluser(Long Userid)
    {
         deliveryRepo.deleteById(Userid);
    }
    
    public List<Delivery> page(int pageSize,int pageNumber)
  {
    PageRequest page=PageRequest.of(pageNumber,pageSize);
    return deliveryRepo.findAll(page).getContent();
  }
  public List<Delivery> sort(String field)
  {
    Sort sort=Sort.by(Sort.Direction.ASC,field);
    return deliveryRepo.findAll(sort);
  }
  public List<Delivery> getpagesort(int pageNumber,int pageSize,String field)
  {
    return deliveryRepo.findAll(PageRequest.of(pageNumber,pageSize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
  }
}
