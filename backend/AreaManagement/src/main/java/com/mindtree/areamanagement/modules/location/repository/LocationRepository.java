package com.mindtree.areamanagement.modules.location.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.areamanagement.modules.location.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	public Location findByLocationName(String locationName);

}