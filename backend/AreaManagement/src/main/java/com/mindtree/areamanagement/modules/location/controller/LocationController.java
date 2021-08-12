package com.mindtree.areamanagement.modules.location.controller;
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

import com.mindtree.areamanagement.modules.location.dto.LocationDto;
import com.mindtree.areamanagement.modules.location.service.LocationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/location")
	public ResponseEntity<LocationDto> addLocation(@RequestBody LocationDto locationDto) {
		System.out.println(locationDto.getLocationName());
		LocationDto addedLocationDto = this.locationService.addLocation(locationDto);
		return new ResponseEntity<LocationDto>(addedLocationDto, HttpStatus.CREATED);
	}

	@GetMapping("/location")
	public ResponseEntity<List<LocationDto>> getLocations() {
		List<LocationDto> locationDto= locationService.getLocations();
		return new ResponseEntity<List<LocationDto>>(locationDto, HttpStatus.OK);
	}
	@DeleteMapping("/location/{locationName}")
	public LocationDto deleteLocation(@PathVariable String locationName) {
		return this.locationService.deleteLocation(locationName);
	}
	
	@GetMapping("/location/{locationName}")
	public ResponseEntity<LocationDto> getLocationByName(@PathVariable("locationName") String locationName) {
		LocationDto locationDto= locationService.findLocation(locationName);
		return new ResponseEntity<LocationDto>(locationDto, HttpStatus.OK);
	}

//	@PutMapping("/location/{id}")
//	public ResponseEntity<LocationDto> updateLocation(@RequestBody LocationDto locationDto, @PathVariable long id) {
//		LocationDto updateLocationDto = locationService.updateLocation(locationDto, id);
//
//		return new ResponseEntity<LocationDto>(updateLocationDto, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/location/{id}")
//	public LocationDto deleteLocation(@PathVariable long id) {
//		return this.locationService.deleteLocation(id);
//	}
}