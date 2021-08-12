package com.mindtree.areamanagement.modules.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.areamanagement.modules.location.entity.Location;
import com.mindtree.areamanagement.modules.user.dto.UserDto;
import com.mindtree.areamanagement.modules.user.entity.User;
import com.mindtree.areamanagement.modules.user.repository.UserRepository;


@Service
public class UserService implements UserDetailsService
 
{
	User user=null;
	
	@Autowired
	private UserRepository userRepository;
	
	ModelMapper modelMapper=new ModelMapper();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user=userRepository.findByUserName(username);
		System.out.println(user.getEmail());
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		return new UserPrincipal(user);
	}
	
	public User convertDtoToEntity(UserDto userDto)
	{
		return modelMapper.map(userDto,User.class);
	}
	
	public UserDto convertEntityToDto(User user)
	{
		return modelMapper.map(user, UserDto.class);
	}


	public UserDto addUser(UserDto userDto) {
		User user=convertDtoToEntity(userDto);
		//user.setLocation(new Location());
		user=userRepository.save(user);
		return userDto;
	}

	public List<UserDto> retreiveAllUser() {
			List <UserDto> userList = new ArrayList<UserDto>();
			for (User i : userRepository.findAll()) {
				userList.add(convertEntityToDto(i));
			}
			return userList;
	}

	public UserDto getUserDetailsByEmail(String email) {
		User user= userRepository.findByEmail(email);
		UserDto userDto=convertEntityToDto(user);
		return userDto;
	}
	
	public UserDto getUserDetailsByName(String name) {
		User user= userRepository.findByUserName(name);
		System.out.println(user.getEmail());
		UserDto userDto=convertEntityToDto(user);
		return userDto;
	}
	
	public UserDto getCurrentUser() {
		return convertEntityToDto(user);
	}

	public UserDto deleteParticularUserByEmail(String email) {
		UserDto userDeleted = convertEntityToDto(userRepository.findByEmail(email));
		userRepository.deleteByEmail(email);
		if (userRepository.findByEmail(email) != null) {
			return userDeleted;
		}
		return null;
	}

	
	public UserDto updateUserProfile(String email, UserDto userDto) {
	    User user = userRepository.findByEmail(email);
	    user.setPhone(userDto.getPhone());
	    user.setUserName(userDto.getUserName());
	    user.setAddress(userDto.getAddress());
	    Location location=userDto.getLocation();
	    user.setLocation(location);
		UserDto updatedUserDetails = convertEntityToDto(userRepository.save(user));
		return updatedUserDetails;
		
	}
	
	public UserDto updateUserPassword(String email, UserDto userDto) {
		 User user = userRepository.findByEmail(email);
		    user.setPassword(userDto.getPassword());
			UserDto updatedUserDetails = convertEntityToDto(userRepository.save(user));
			return updatedUserDetails;
	}

	public List<UserDto> getAllTheUsersBelongtoAreaManagerLocation(String email) {
		List <UserDto> userList = new ArrayList<UserDto>();
		for (User i : userRepository.getAllTheUsersBelongtoAreaManagerLocation(email)) {
			userList.add(convertEntityToDto(i));
		}
		return userList;
	}

	public UserDto getAreaManager(String email) {
		// UserDto areaManagerDetails;
		return	convertEntityToDto(userRepository.getAreaManager(email)); 

	}
	
	public List<UserDto> retreiveAllUsers() {
		List<User> users=userRepository.findAllUsers();
//		users.stream().filter(e->e.getRole()=="USER").collect(Collectors.toList());
		return users.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}
	
	public List<UserDto> retreiveAllAreaManagers() {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findAllAreaManagers();
//		users.stream().filter(e->e.getRole()=="AREAMANAGER").collect(Collectors.toList());
		return users.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public List<UserDto> retreiveAllAreaManagersByLocationName(String locationName) {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findAllAreaManagers();
//		users.stream().filter(e->e.getRole()=="AREAMANAGER").collect(Collectors.toList());
		List<User> sortedList= users.stream().filter(e->e.getLocation().getLocationName().equalsIgnoreCase(locationName)).collect(Collectors.toList());
		return sortedList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}
	
	public List<UserDto> retreiveAllUsersByLocationName(String locationName) {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findAllUsers();
//		users.stream().filter(e->e.getRole()=="USER").collect(Collectors.toList());
		List<User> sortedList= users.stream().filter(e->e.getLocation().getLocationName().equalsIgnoreCase(locationName)).collect(Collectors.toList());
		System.out.println("sorted method is started");
		return sortedList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public UserDto updateUserProfileDetails(UserDto userDto) {
		User user=userRepository.findByUserName(userDto.getUserName());
		 user.setPhone(userDto.getPhone());
		    user.setUserName(userDto.getUserName());
		    user.setAddress(userDto.getAddress());
		    Location location=userDto.getLocation();
		    user.setLocation(location);
		    userRepository.save(user);
		return convertEntityToDto(user);
	}

}
