package com.itvedant.petstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServices {
	@Autowired
	PetRepository repository;
	
	public PetF addPet(PetF pet) {
		PetF addedpet=repository.save(pet);
		System.out.println(addedpet);
		return addedpet;
	}
	public List<PetF> viewAllPet() {
		List<PetF> petlist=repository.findAll();
		return petlist;		
	}
	public PetF viewOnePet(Integer id) {
		PetF pet=repository.findById(id).orElse(null);
		return pet;		
			}
	public String updateProduct(Integer id, PetF pet) {
		PetF pettobeupdated=repository.findById(id).orElse(null);
		if(pettobeupdated==null) {
			return "Product is not available";
		}
		else {
			pettobeupdated.setName(pet.getName());
			pettobeupdated.setDescription(pet.getDescription());
			pettobeupdated.setManufacture(pet.getManufacture());
			pettobeupdated.setPrice(pet.getPrice());
			return "Product is updated";
		}
		}
	public String deleteAllProducts() {
		repository.deleteAll();
		return "All Products is deleted";		
	}				
	}

	
