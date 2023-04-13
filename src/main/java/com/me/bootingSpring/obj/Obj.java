package com.me.bootingSpring.obj;

//TODO use interface/ abstract class for Obj

//import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
//import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table
public class Obj {

    @SequenceGenerator(
        name = "obj_sequence",
        sequenceName = "obj_sequence",
        allocationSize = 1
    )
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "obj_sequence"
    )
    Integer id;
    String name;
    //LocalDate doc;
    LocalDateTime toc;

    @Transient  //ie not in DB
    Long age;

    public Obj() {
        this.toc = LocalDateTime.now();
    }

    public Obj(String name, Integer id,LocalDateTime toc) {
        this.name = name;
        this.id = id;
        this.toc = toc;
    }

    public Obj(String name,LocalDateTime toc) {
        this.name = name;
        this.toc = toc; 
    }
    
    public Obj(String name) {
        this.name = name;
        this.toc = LocalDateTime.now();
    }

    public String getName(){
        return this.name;
    }
    public Integer getId(){
        return this.id;
    }

    public LocalDateTime getToc() {
        return this.toc;
    } 
    
    public Long getAge() {
        return this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setToc(LocalDateTime toc) {
        this.toc = toc;
    }
    public void setAge() {
        LocalDateTime now = LocalDateTime.now();
        if (now.getYear()<toc.getYear()) {
            throw new IllegalStateException("Timestamp is corrput");
        }
        this.age = ChronoUnit.SECONDS.between(toc,now);
    }

    @Override
    public String toString() {
        return "Obj [id=" + id + ", name=" + name + ", toc=" + toc + ", age=" + age  + "]";
    }

}