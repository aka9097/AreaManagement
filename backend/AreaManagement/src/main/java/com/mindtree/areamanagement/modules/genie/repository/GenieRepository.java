package com.mindtree.areamanagement.modules.genie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.areamanagement.modules.genie.entity.Genie;

@Repository
public interface GenieRepository extends JpaRepository<Genie, Integer> {

	public Genie findById(int id);

	// Custom query to find genie by user id using inner join

	@Query(value = "SELECT G.* FROM GENIE G INNER JOIN GENIE_USERS GU ON G.ID=GU.GENIE_ID WHERE GU.USERS_ID=?1", nativeQuery = true)
	public List<Genie> findGenieByUserId(long getId);

	public Genie deleteById(int genieId);
	
    @Query(value="call displayGenieDetailsOfParticularLocation(?1)",nativeQuery = true)
	public List<Genie> getAllGeniesOfLocationUnderAreaManager(String email);

}
