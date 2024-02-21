package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.App;
import com.example.demo.model.Delivery;
import com.example.demo.repository.AppRepo;
import com.example.demo.repository.DeliveryRepo;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepo deliveryRepo;
    public Delivery addDelivery(Delivery delivery)
    {
        return deliveryRepo.save(delivery);
    }
    public List<Delivery> getDelivery()
    {
        return deliveryRepo.findAll();
    }
    public Optional<Delivery> getDeliveryById(long Userid)
    {
        return deliveryRepo.findById(Userid);
    }
    public Delivery edituser(Long Userid,Delivery delivery)
    {
        Delivery DeliveryAvail = deliveryRepo.findById(Userid).orElse(null);
        if(DeliveryAvail !=null)
        {    
              DeliveryAvail.setEmailid(delivery.getEmailid());
              DeliveryAvail.setUsername(delivery.getUsername());
              DeliveryAvail.setPassword(delivery.getPassword());
              DeliveryAvail.setConfirmPassword(delivery.getConfirmPassword());
             return deliveryRepo.saveAndFlush(DeliveryAvail);
        }
        else
        return null;
    }

    public void deluser(Long Userid)
    {
         deliveryRepo.deleteById(Userid);
    }
    @Autowired
    AppRepo appRepo;
    public App addApp(App app)
    {
        return appRepo.save(app);
    }
    public List<App> getApp()
    {
        return appRepo.findAll();
    }
    public Optional<App> getAppById(long orderId)
    {
        return appRepo.findById(orderId);
    }
    public App edituserapp(Long orderId,App app)
    {
        App AppAvail = appRepo.findById(orderId).orElse(null);
        if(AppAvail !=null)
        {    
              AppAvail.setRestaurantName(app.getRestaurantName());
              AppAvail.setCuisineType(app.getCuisineType());
              AppAvail.setDeliveryTime(app.getDeliveryTime());
              AppAvail.setPrizeRange(app.getPrizeRange());
              AppAvail.setRating(app.getRating());
             return appRepo.saveAndFlush(AppAvail);
        }
        else
        return null;
    }

    public void deluserapp(Long orderId)
    {
         appRepo.deleteById(orderId);
    }
}
