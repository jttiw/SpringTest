package com.me.bootingSpring.obj;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api/obj")
public class ObjController {
    
    private final ObjService objService;

    @Autowired
    public ObjController(ObjService objService) {
        this.objService = objService; 
    }

    @GetMapping()
    public List<Obj> getObjs() {
        //List<LocalDateTime> result = Collections.emptyList();
        
        //if query for 1
        //Obj test = objService.getObjs().get(00);
        //test.setAge();
        objService.getObjs().forEach(i->i.setAge());
        
        return objService.getObjs();
    }

    @PostMapping()
    public void addNewObj(@RequestBody Obj obj) {
        objService.addNewObj(obj);
    }

    @DeleteMapping()
    public void deleteObject(@RequestParam String id){
        objService.deleteObj(id);
    }

    @PutMapping(path = "{id}")
    public void updateObj(@PathVariable("id") Integer id, @RequestParam(required = true) String name) {
        objService.updateObj(id, name);
    }
    
}
