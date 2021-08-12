package com.mindtree.areamanagement.modules.genie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.areamanagement.modules.genie.dto.GenieDto;
import com.mindtree.areamanagement.modules.genie.entity.Genie;
import com.mindtree.areamanagement.modules.genie.service.GenieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GenieController {

	@Autowired
	private GenieService genieService;

	// Add/Raise new Genie
	
	@PostMapping("/raiseGenie/{email}")
	public ResponseEntity<?> addGenie(@RequestBody GenieDto genieDto,@PathVariable String email) {
		GenieDto addedGenie = genieService.addGenieDetails(genieDto,email);
		return new ResponseEntity<GenieDto>(addedGenie, HttpStatus.CREATED);
	}


//	@PostMapping("/raiseGenie")
//	public ResponseEntity<?> addGenie(@RequestBody GenieDto genieDto) {
//		GenieDto addedGenie = genieService.addGenieDetails(genieDto);
//		return new ResponseEntity<GenieDto>(addedGenie, HttpStatus.CREATED);
//	}

	// Get particular Genie details

	@GetMapping("/genies/{genieId}")
	public ResponseEntity<?> getParticularGenieById(@PathVariable int genieId) {
		GenieDto foundGenie = genieService.getGenie(genieId);
		return new ResponseEntity<GenieDto>(foundGenie, HttpStatus.OK);
	}

	// Get all Genie details

	@GetMapping("/genie")
	public ResponseEntity<?> getAllGenieDetails() {
		List<GenieDto> geniesList = genieService.retreiveAllGenie();
		return new ResponseEntity<List<GenieDto>>(geniesList, HttpStatus.OK);
	}

	// Delete particular Genie

	@DeleteMapping("/genie/{genieId}")
	public ResponseEntity<?> deleteParticularGenie(@PathVariable int genieId) {
		Genie deletedGenie = genieService.deleteParticularGenieById(genieId);
		return new ResponseEntity<Genie>(deletedGenie, HttpStatus.OK);
	}

	// Get All Genies by User email

	@GetMapping("/geniee/{userEmail}")
	public ResponseEntity<?> getAllGenieByUser(@PathVariable String userEmail) {
		List<GenieDto> foundGenies = genieService.getAllGenieByUser(userEmail);
		return new ResponseEntity<List<GenieDto>>(foundGenies, HttpStatus.OK);
	}

	
	

	// Update Genie Details

	@PutMapping("/genie/{genieId}")
	public ResponseEntity<?> updateGenieDetails(@PathVariable int genieId, @RequestBody GenieDto genieDto) {
		GenieDto updatedGenie = genieService.updateGenieDetails(genieId, genieDto);
		return new ResponseEntity<GenieDto>(updatedGenie, HttpStatus.OK);
	}

	// Update Genie Status

	@PutMapping("/genie/status/{genieId}")
	public ResponseEntity<?> updateGenieStatus(@PathVariable int genieId, @RequestBody GenieDto genieDto) {
		GenieDto updatedGenieStatus = genieService.updateGenieStatus(genieId, genieDto);
		return new ResponseEntity<GenieDto>(updatedGenieStatus, HttpStatus.OK);
	}
	
	
	//get all genies of particular location for area manager
	@GetMapping("/genies/areamanager/{email}")
	public ResponseEntity<?> getAllGeniesOfLocationUnderAreaManager(@PathVariable String email) {
		List<GenieDto> foundGenies = genieService.getAllGeniesOfLocationUnderAreaManager(email);
		return new ResponseEntity<List<GenieDto>>(foundGenies, HttpStatus.OK);
	}
	
	//get all genies of particular location for user
	@GetMapping("/genie/user/{email}")
	public ResponseEntity<List<GenieDto>> getAllGeniesOfLocationOfUser(@PathVariable String email) {
		return new ResponseEntity<>(genieService.getAllGeniesOfLocationUnderAreaManager(email), HttpStatus.OK);
	}
	
//	@GetMapping("/genie/user/{email}")
//	public List<GenieDto> getAllGeniesOfLocationOfUser(@PathVariable String email) {
//		List<GenieDto> foundGenies = genieService.getAllGeniesOfLocationUnderAreaManager(email);
//		return foundGenies;
//	}

}