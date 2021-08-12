package com.mindtree.areamanagement.modules.genie.service;

import java.util.List;

import com.mindtree.areamanagement.modules.genie.dto.GenieDto;
import com.mindtree.areamanagement.modules.genie.entity.Genie;

public interface GenieService {

   // public GenieDto addGenieDetails(GenieDto genieDto);
    
    public GenieDto addGenieDetails(GenieDto genieDto,String email);

	public GenieDto getGenie(int genieId);

	public List<GenieDto> retreiveAllGenie();

	public Genie deleteParticularGenieById(int genieId);

	public List<GenieDto> getAllGenieByUser(String userEmail);

	public GenieDto updateGenieDetails(int genieId, GenieDto genieDto);

	public GenieDto updateGenieStatus(int genieId, GenieDto genieDto);

	public List<GenieDto> getAllGeniesOfLocationUnderAreaManager(String email);

}
