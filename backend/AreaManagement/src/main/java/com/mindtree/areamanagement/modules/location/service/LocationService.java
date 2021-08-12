package com.mindtree.areamanagement.modules.location.service;

import java.util.List;

import com.mindtree.areamanagement.modules.location.dto.LocationDto;

public interface LocationService {

	public LocationDto addLocation(LocationDto locationDto);

	public List<LocationDto> getLocations();

	public LocationDto updateLocation(LocationDto locationDto, long id);

	public LocationDto deleteLocation(long id);

	public LocationDto findLocation(String locationName);

	public LocationDto deleteLocation(String locationName);

}
