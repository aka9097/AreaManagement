package com.mindtree.areamanagement.modules.location.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.areamanagement.modules.location.dto.LocationDto;
import com.mindtree.areamanagement.modules.location.entity.Location;
import com.mindtree.areamanagement.modules.location.repository.LocationRepository;
import com.mindtree.areamanagement.modules.location.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;

	ModelMapper modelMapper = new ModelMapper();

	public LocationDto addLocation(LocationDto locationDto) {
		Location location = convertDtoToEntity(locationDto);
		locationRepository.save(location);
		LocationDto newLocationDto = convertEntityToDto(location);
		return newLocationDto;
	}

	public Location convertDtoToEntity(LocationDto locationDto) {
		return modelMapper.map(locationDto, Location.class);
	}

	public LocationDto convertEntityToDto(Location location) {
		return modelMapper.map(location, LocationDto.class);
	}

	public List<LocationDto> getLocations() {
		List<LocationDto> locationList = new ArrayList<LocationDto>();
		for (Location location : locationRepository.findAll()) {
			locationList.add(convertEntityToDto(location));
		}
		return locationList;
	}

	public LocationDto updateLocation(LocationDto locationDto, long id) {

		LocationDto location = convertEntityToDto(locationRepository.getById(id));
		System.out.println(location.getCity());
		location.setLocationName(locationDto.getLocationName());
		location.setCity(locationDto.getCity());
		location.setPincode(locationDto.getPincode());
		Location newLocation = convertDtoToEntity(location);
		locationRepository.save(newLocation);
		return location;
	}

	public LocationDto deleteLocation(long id) {
		LocationDto deletedDto = convertEntityToDto(locationRepository.getById(id));
		locationRepository.deleteById(id);
		return deletedDto;
	}

//	public LocationDto findLocation(String locationName) {
//	     return locationRepository.findByLocationName(locationName);	
//	}
	public LocationDto deleteLocation(String locationName) {
		Location location=locationRepository.findByLocationName(locationName);
		locationRepository.delete(location);
		LocationDto deletedDto = convertEntityToDto(location);
		return deletedDto;
	}

	public LocationDto findLocation(String locationName) {
	     return convertEntityToDto(locationRepository.findByLocationName(locationName));	
	}

}