package com.mindtree.areamanagement.modules.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.areamanagement.modules.admin.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	
	public Admin findByEmail(String email);
	
	@Query(value="select * from admin where email=:e and password=:p", nativeQuery = true)
	public Admin findByEmailAndPassword(@Param("e")String email,@Param("p") String password);

	public Admin findByUserName(String username);

}
