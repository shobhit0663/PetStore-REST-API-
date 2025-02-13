package com.itvedant.petstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PetController {
@Autowired
PetServices service;

@PostMapping("/addProduct")
public ResponseEntity<?> addPet(@RequestBody PetF pet){
	PetF addedPet=service.addPet(pet);
	return ResponseEntity.ok("Product Added Successfully!!");	
}

@GetMapping("/getProducts")
public ResponseEntity<?> viewAllPet(){
	List <PetF> petlist=service.viewAllPet();
	return ResponseEntity.ok(petlist);
}

@GetMapping("/getOneProd")
public ResponseEntity<?> viewOnePet(@RequestParam Integer id){
	PetF pet=service.viewOnePet(id);
	if(pet==null) {
		return ResponseEntity.ok("car not found");
	}
	else {
		return ResponseEntity.ok(pet);
	}
}

@PutMapping("/updatePro")
public ResponseEntity<?> updateProduct(@RequestParam Integer id,@RequestBody PetF pet){
	String msg=service.updateProduct(id,pet);
	return ResponseEntity.ok(msg);
}

@DeleteMapping("/deleteAll")
public ResponseEntity<?> deleteAllProduct(){
	String msg=service.deleteAllProducts();
	return ResponseEntity.ok(msg);
}
}
