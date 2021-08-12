package com.mindtree.areamanagement.modules.admin.service;

import java.util.List;

import com.mindtree.areamanagement.modules.admin.dto.AdminDto;
import com.mindtree.areamanagement.modules.user.dto.UserDto;

public interface AdminService {

	public AdminDto addAdminDetails(AdminDto adminDto);

	public List<AdminDto> retreiveAllAdmin();

	public AdminDto updateAdminProfile(AdminDto adminDto, String email);

	public AdminDto updateAdminPassword(String email, AdminDto adminDto);

	public AdminDto getAdminDetailsByEmailAndPassword(String email, String password);

	public AdminDto getCurrentUser();

}
