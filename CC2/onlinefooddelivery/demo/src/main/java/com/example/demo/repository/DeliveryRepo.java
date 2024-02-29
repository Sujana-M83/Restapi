package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Delivery;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery,Long>{

    
} 