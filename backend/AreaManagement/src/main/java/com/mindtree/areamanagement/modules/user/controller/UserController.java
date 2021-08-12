package com.mindtree.areamanagement.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.areamanagement.modules.location.service.LocationService;
import com.mindtree.areamanagement.modules.user.dto.UserDto;
import com.mindtree.areamanagement.modules.user.entity.User;
import com.mindtree.areamanagement.modules.user.service.UserPrincipal;
import com.mindtree.areamanagement.modules.user.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private LocationService locationService;
	@RequestMapping("/login")
    public String login() {
		return "login successfully";	
	}
	
	@GetMapping("/currentuser")
	public UserDto currentUser() {
		return userService.getCurrentUser();
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> insertUsers(@RequestBody UserDto userDto){
		userDto=userService.addUser(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getUsers() {
		List<UserDto> UserDtoList = userService.retreiveAllUser();
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}
	
	@PutMapping("/user/updateProfile/{email}")
	public ResponseEntity<UserDto> updateUserProfile(@PathVariable String email, @RequestBody UserDto userDto) {
		 userDto= userService.updateUserProfile(email, userDto);
		 return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	@PutMapping("/updateUserProfile")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		 userDto= userService.updateUserProfileDetails(userDto);
		 return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
			
	@GetMapping("/user/{email}")
	public ResponseEntity<UserDto> getUsersByEmail(@PathVariable("email") String email) {
		UserDto userDetails = userService.getUserDetailsByEmail(email);
		return new ResponseEntity<UserDto>(userDetails, HttpStatus.OK);
	}
	
	//display area manager of user location
	@GetMapping("/user/areamanager/{email}")
	public ResponseEntity<UserDto> getAreaManager(@PathVariable("email") String email) {
		UserDto userDetails = userService.getAreaManager(email);
		return new ResponseEntity<UserDto>(userDetails, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable("email") String email) {
		userService.deleteParticularUserByEmail(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/areamanager/{email}")
	public ResponseEntity<?> updatePasswordOfAreamanager(@PathVariable String email, @RequestBody UserDto uaserDto) {
		UserDto userDtoDetails =userService.updateUserPassword(email, uaserDto);
		return new ResponseEntity<UserDto>(userDtoDetails, HttpStatus.OK);
	}
	
	@PutMapping("/user/{email}")
	public ResponseEntity<?> updatePasswordOfUser(@PathVariable String email, @RequestBody UserDto uaserDto) {
		UserDto userDtoDetails =userService.updateUserPassword(email, uaserDto);
		return new ResponseEntity<UserDto>(userDtoDetails, HttpStatus.OK);
	}
	
	@GetMapping("/areamanager/{email}")
	public ResponseEntity<?> getAllTheUsersBelongtoAreaManagerLocation(@PathVariable String email) {
		List<UserDto> UserDtoList = userService.getAllTheUsersBelongtoAreaManagerLocation(email);
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}
	
	@PutMapping("/areamanager/updateprofile/{email}")
	public ResponseEntity<UserDto> updateAreaManager(@PathVariable String email, @RequestBody UserDto userDto) {
		UserDto updatedUserDto=userService.updateUserProfile(email,userDto);
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);
	}
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<UserDto> UserDtoList = userService.retreiveAllUsers();
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/areamanagers")
	public ResponseEntity<?> getAllAreaManagers() {
		List<UserDto> UserDtoList = userService.retreiveAllAreaManagers();
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/areamanagers/{locationName}")
	public ResponseEntity<?> getAllAreaManagersByLocationName(@PathVariable String locationName) {
		List<UserDto> UserDtoList = userService.retreiveAllAreaManagersByLocationName(locationName);
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{locationName}")
	public ResponseEntity<List<UserDto>> getAllUsersByLocationName(@PathVariable String locationName) {
		List<UserDto> UserDtoList = userService.retreiveAllUsersByLocationName(locationName);
		return new ResponseEntity<List<UserDto>>(UserDtoList, HttpStatus.OK);
	}

}
