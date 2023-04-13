package com.me.bootingSpring.obj;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjRepository extends JpaRepository<Obj, Integer>{

    @Query(("SELECT o FROM Obj o WHERE o.name = ?1"))
    Optional<Obj> findByName(String name);
    
}
