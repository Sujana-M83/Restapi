package com.example.d7ex3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.d7ex3.model.Door;
import com.example.d7ex3.service.DoorService;

@RestController
@RequestMapping("/api/door")
public class DoorController {
    @Autowired
    DoorService doorService;

    @PostMapping
    public ResponseEntity<?> saveDoor(@RequestBody Door door)
    {
        try{
            doorService.saveDoor(door);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping
    public ResponseEntity<?> getDoor()
    {
        try{
            return ResponseEntity.status(200).body(doorService.getAllDoors());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    
    @GetMapping("/doorid/{doorId}")
    public ResponseEntity<?> getAllDoorsByDoorId(@PathVariable ("doorId") int doorId)
    {
        try{
            return ResponseEntity.status(200).body(doorService.getAllDoorsByDoorId(doorId));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/accessType/{accessType}")
    public ResponseEntity<?> getAllDoorsByAccessType(@PathVariable ("accessType") String accessType)
    {
        try{
            return ResponseEntity.status(200).body(doorService.getAllDoorsByAccessType(accessType));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }


}
