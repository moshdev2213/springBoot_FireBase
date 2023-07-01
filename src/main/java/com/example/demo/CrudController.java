package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.ExecutionError;

@RestController
public class CrudController {
	public CrudService crudService;
	public CrudController(CrudService crudService) {
		this.crudService = crudService;
	}
	//create CRUD 
	@PostMapping("/create")
	public String createCRUD(@RequestBody Crud crud) throws InterruptedException , ExecutionException{
		return crudService.createCRUD(crud);
		
	}
	//retrive data
	@GetMapping("/get")
	public Crud getCrud(@RequestParam String docId)  throws InterruptedException , ExecutionException{
		return crudService.getCRUD(docId);
	}
	//update DAta
	@PutMapping("/update")
	public String updateCRUD(@RequestBody Crud crud)  throws InterruptedException , ExecutionException{
		return crudService.updateCRUD(crud);
	}
	//delete data
	@DeleteMapping("/delete")
	public String deleteCRUD(@RequestParam String docId) throws InterruptedException , ExecutionException{
		return crudService.deleteCRUD(docId);
	}
	
}
