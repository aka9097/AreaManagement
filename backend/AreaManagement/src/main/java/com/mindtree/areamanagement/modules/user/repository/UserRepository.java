package com.mindtree.areamanagement.modules.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.areamanagement.modules.user.dto.UserDto;
import com.mindtree.areamanagement.modules.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Byte>{

	public User findByUserName(String username);

	public User findByEmail(String email);

	@Transactional
	public void deleteByEmail(String email);

	public UserDto save(UserDto userDto);
	
    @Query(value="call displayUserDetailsOfParticularAreaManagerLocation(?1)",nativeQuery = true)
	public List<User> getAllTheUsersBelongtoAreaManagerLocation(String email);

    @Query(value="select * from user where lower(role) in ('AREAMANAGER') and location_id in  (select location_id from user where email =?1);",nativeQuery=true)
	public User getAreaManager(String email);

    @Query(value="select * from user where upper(role)='AREAMANAGER'",nativeQuery = true)
	public List<User> findAllAreaManagers();

//    @Query(value="select * from user inner join location where user.location_id=location.id and upper(user.role)='AREAMANAGER' and location.location_name=?1;",nativeQuery = true)
//	public List<User> findAllAreaManagers(String locationName);
    
	@Query(value="select * from user where upper(role)='USER'",nativeQuery = true)
	public List<User> findAllUsers();

	@Transactional
	public void deleteById(int id);

}
