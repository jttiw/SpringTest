package com.test2.test2.obj;

//TODO use interfeace/ abstract class

//import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    LocalDate doc;
    LocalTime toc;

    @Transient  //ie not in DB
    LocalDateTime age;

    public Obj() {
        this.doc = LocalDate.now();
        this.toc = LocalTime.now();
    }

    public Obj(String name, Integer id, LocalDate doc, LocalTime toc) {
        this.name = name;
        this.id = id;
        this.doc = doc;
        this.toc = toc;
    }

    public Obj(String name, LocalDate doc, LocalTime toc) {
        this.name = name;
        this.doc = doc;
        this.toc = toc; 
    }
    
    public Obj(String name) {
        this.name = name;
        this.doc = LocalDate.now();
        this.toc = LocalTime.now(); 
    }

    public String getName(){
        return this.name;
    }
    public Integer getId(){
        return this.id;
    }

    public LocalDate getDoc() {
        return this.doc;
    }
    public LocalTime getToc() {
        return this.toc;
    } 
    
    public LocalDateTime getAge() {
        return this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }
    public void setToc(LocalTime toc) {
        this.toc = toc;
    }
    public void setAge() {
        this.age = LocalDateTime.of(doc,toc);
    }

    @Override
    public String toString() {
        return "Obj [id=" + id + ", name=" + name + ", doc=" + doc + ", toc=" + toc + ", age=" + age  + "]";
    }

}