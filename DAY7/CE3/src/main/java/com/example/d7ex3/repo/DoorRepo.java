package com.example.d7ex3.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.d7ex3.model.Door;

public interface DoorRepo extends JpaRepository<Door,Integer>{
    @Modifying
    @Query("insert into Door(doorId,location,accessCode,accessType) values (?1,?2,?3,?4)")
    void saveDoor(int doorId,String location,String accessCode,String accessType);

    @Query("Select a from Door a")
    List<Door> findAllDoors();

    @Query("Select a from Door a where a.doorId=?1")
    List<Door> findByDoorId(int doorId);

    @Query("Select a from Door a where a.accessType=?1")
    List<Door> findByAccessType(String accessType);

    Optional<Door> findByAccessCode(String accessCode);
}
