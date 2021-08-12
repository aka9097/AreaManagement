package com.mindtree.areamanagement.modules.address.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.areamanagement.modules.address.dto.AddressDto;
import com.mindtree.areamanagement.modules.address.entity.Address;
import com.mindtree.areamanagement.modules.address.repository.AddressRepository;
import com.mindtree.areamanagement.modules.address.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	ModelMapper modelMapper=new ModelMapper();
	
	public AddressDto addAddress(AddressDto addressDto) {
		
			Address address = convertDtoToEntity(addressDto);
			Address addressResult = addressRepository.save(address);
			AddressDto addressDto1 = convertEntityToDto(addressResult);
			return addressDto1;
			}

	public Address convertDtoToEntity(AddressDto addressDto) {
		return modelMapper.map(addressDto, Address.class);
	}

	public AddressDto convertEntityToDto(Address address) {
		return modelMapper.map(address, AddressDto.class);
	}

	public List<AddressDto> getaddressDetails() {
		
			List<AddressDto> addressList = new ArrayList<AddressDto>();
			for (Address address : addressRepository.findAll()) {
				addressList.add(convertEntityToDto(address));
			}
			return addressList;
			
	}

	public AddressDto deleteAddress(int id) {
		AddressDto addressToBeDeleted = convertEntityToDto(addressRepository.getById(id));
		addressRepository.deleteById(id);
			return addressToBeDeleted;
	
	}

	public AddressDto getAddressById(int id) {
		AddressDto address = convertEntityToDto(addressRepository.getById(id));
		return address;
	}

	public AddressDto updateAddress(int id, AddressDto addressDto) {
		AddressDto updatedAddress = convertEntityToDto(addressRepository.save(convertDtoToEntity(addressDto)));
		return updatedAddress;
	}

	public AddressDto updateAddressDetails(int addressId, AddressDto addressDto) {
		Address addressDetails = addressRepository.findById(addressId);
		addressDetails.setFlatNo(addressDto.getFlatNo());
		addressDetails.setAddress1(addressDto.getAddress1());
		addressDetails.setAddress2(addressDto.getAddress2());
		AddressDto updatedAddress = convertEntityToDto(addressRepository.save(addressDetails));
		return updatedAddress;
	}

		
	
}
