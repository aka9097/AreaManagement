package com.mindtree.areamanagement.modules.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.areamanagement.modules.admin.dto.AdminDto;
import com.mindtree.areamanagement.modules.admin.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/adminLogin")
    public String login() {
		return "login successfully";	
	}
	
//	@GetMapping("/currentuser")
//	public AdminDto currentUser() {
//		return adminService.getCurrentUser();
//		
//	}
	
	@PostMapping("/admin")
	public ResponseEntity<AdminDto> insertAdminDetails(@RequestBody AdminDto adminDto){
		adminDto=adminService.addAdminDetails(adminDto);
		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<?> getAdminDetails() {
		List<AdminDto> AdminDtoList = adminService.retreiveAllAdmin();
		return new ResponseEntity<List<AdminDto>>(AdminDtoList, HttpStatus.FOUND);
	}
	
	@PutMapping("/admin/updateprofile/{email}")
	public ResponseEntity<AdminDto> updateAdminDetails( @RequestBody AdminDto adminDto, @PathVariable("email") String email) {
		AdminDto adminDtoDetails =adminService.updateAdminProfile(adminDto,email);
		return new ResponseEntity<AdminDto>(adminDtoDetails, HttpStatus.OK);
	}
	
	@PutMapping("/admin/{email}")
	public ResponseEntity<?> updatePasswordOfAdmin(@PathVariable String email, @RequestBody AdminDto adminDto) {
		AdminDto adminDtoDetails =adminService.updateAdminPassword(email, adminDto);
		return new ResponseEntity<AdminDto>(adminDtoDetails, HttpStatus.OK);
	}
		
	@GetMapping("/admin/{email}/{password}")
	public AdminDto getAdminByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password) {
		AdminDto foundadmin = adminService.getAdminDetailsByEmailAndPassword(email,password);
//		return new ResponseEntity<AdminDto>(foundadmin, HttpStatus.OK);
		return foundadmin;
	}
	
}