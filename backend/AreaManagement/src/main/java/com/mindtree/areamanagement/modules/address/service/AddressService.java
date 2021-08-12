package com.mindtree.areamanagement.modules.address.service;

import java.util.List;

import com.mindtree.areamanagement.modules.address.dto.AddressDto;

public interface AddressService {

	public AddressDto addAddress(AddressDto addressDto);

	public List<AddressDto> getaddressDetails();

	public AddressDto deleteAddress(int id);

	public AddressDto getAddressById(int id);

	public AddressDto updateAddressDetails(int addressId, AddressDto addressDto);

}
