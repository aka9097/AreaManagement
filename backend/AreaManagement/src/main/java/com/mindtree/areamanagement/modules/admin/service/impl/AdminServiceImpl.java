package com.mindtree.areamanagement.modules.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.areamanagement.modules.admin.dto.AdminDto;
import com.mindtree.areamanagement.modules.admin.entity.Admin;
import com.mindtree.areamanagement.modules.admin.repository.AdminRepository;
import com.mindtree.areamanagement.modules.admin.service.AdminPrincipal;
import com.mindtree.areamanagement.modules.admin.service.AdminService;
import com.mindtree.areamanagement.modules.user.dto.UserDto;
import com.mindtree.areamanagement.modules.user.service.UserPrincipal;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	ModelMapper modelMapper=new ModelMapper();
	Admin admin;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		admin=adminRepository.findByUserName(username);
		System.out.println(admin.getEmail());
		if(admin==null)
			throw new UsernameNotFoundException("User 404");
		return new AdminPrincipal(admin);
	}
	

	
	public AdminDto addAdminDetails(AdminDto adminDto) {
		Admin admin=convertDtoToEntity(adminDto);
		admin=adminRepository.save(admin);
		return adminDto;
	}

	public List<AdminDto> retreiveAllAdmin() {
			List<AdminDto> userList = new ArrayList<AdminDto>();
			for (Admin i : adminRepository.findAll()) {
				userList.add(convertEntityToDto(i));
			}
			return userList;
	}

	public AdminDto getAdminDetailsByEmail(String email) {
		Admin admin= adminRepository.findByEmail(email);
		AdminDto adminDto=convertEntityToDto(admin);
		return adminDto;
	}

	public Admin convertDtoToEntity(AdminDto adminDto)
	{
		return modelMapper.map(adminDto,Admin.class);
	}
	
	public AdminDto convertEntityToDto(Admin admin)
	{
		return modelMapper.map(admin, AdminDto.class);
	}

	public AdminDto updateAdminProfile( AdminDto adminDto, String email) {
		Admin admin = adminRepository.findByEmail(email);
		admin.setPhone(adminDto.getPhone());
		admin.setUserName(adminDto.getUserName());
		Admin admin1=adminRepository.save(admin);
//		AdminDto updatedAdminDetails = convertEntityToDto(admin1);
//		return updatedAdminDetails;
//		Admin admin=convertDtoToEntity(adminDto);
//		admin=adminRepository.save(admin);
		AdminDto updatedAdminDetails = convertEntityToDto(admin1);
		return updatedAdminDetails;
	}
	
	public AdminDto updateAdminPassword(String email, AdminDto adminDto) {
		Admin admin = adminRepository.findByEmail(email);
		admin.setPassword(adminDto.getPassword());
		Admin admin1=adminRepository.save(admin);
		AdminDto updatedAdminDetails = convertEntityToDto(admin1);
		return updatedAdminDetails;
	}

	@Override
	public AdminDto getAdminDetailsByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Admin admin= adminRepository.findByEmailAndPassword(email,password);
		AdminDto adminDto=convertEntityToDto(admin);
		return adminDto;
	}



	@Override
	public AdminDto getCurrentUser() {
		return convertEntityToDto(admin);
	}

}
