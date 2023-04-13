package com.bootingSpring.obj;

import java.util.Optional;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

//has to instantiated when called (eg. in Controller-> Spring bean
@Service    //could use component but Service is more fitting
public class ObjService {

	private final ObjRepository objRepository;

	@Autowired
	public ObjService(ObjRepository objRepository) {
		this.objRepository = objRepository;
	}
    
	public List<Obj> getObjs() {
		return objRepository.findAll();
	}

	public void addNewObj(Obj obj) {
		Optional<Obj> objByName = objRepository.findByName(obj.name);
		if (objByName.isPresent()) {
			throw new IllegalStateException("name exists already");
		}
		objRepository.save(obj);
	}

	public void deleteObj(String id) {
		Integer obj_id = Integer.parseInt(id);
		Boolean exist = objRepository.existsById(obj_id);
		if (!exist) {
			throw new IllegalStateException("ID does not exist");
		} else {
			objRepository.deleteById(obj_id);
		}
	}

	@Transactional
	public void updateObj(Integer id, String name) {
		Obj obj = objRepository.findById(id).orElseThrow(() -> new IllegalStateException("No obj with id " + id + " found"));
		if (name != null && name.length() > 0 && !Objects.equals(obj.getName(), name)) {
			obj.setName(name);
		} 
	}
}
