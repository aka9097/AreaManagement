package com.mindtree.areamanagement.modules.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.areamanagement.modules.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
	public Address findById(int id);
}
