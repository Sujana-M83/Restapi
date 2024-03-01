package com.example.d7ex3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d7ex3.model.Door;
import com.example.d7ex3.repo.DoorRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoorService {
    @Autowired
    DoorRepo repo;

    public void saveDoor(Door door)
    {
        Optional<Door> doorExists=repo.findByAccessCode(door.getAccessCode());
        if(doorExists.isPresent())
        {
            return;
        }
        repo.saveDoor(door.getDoorId(), door.getLocation(), door.getAccessCode(), door.getAccessType());
    }
    public List<Door> getAllDoors()
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findAllDoors();
    }

    public List<Door> getAllDoorsByDoorId(int doorId)
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findByDoorId(doorId);
    }

    public List<Door> getAllDoorsByAccessType(String accessType)
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findByAccessType(accessType);
    }
}
