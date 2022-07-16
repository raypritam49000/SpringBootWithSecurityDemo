package com.telemune.marketplace.rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.MarketPlaceRoles;

/* 
 * Manjeet Kumar
 * 
 */
public interface MarketPlaceRolesRepository extends JpaRepository<MarketPlaceRoles, Integer> {

	MarketPlaceRoles findByRoleId(Integer roleId);

	void deleteByRoleId(Integer roleId);	
	
	@Query(value = "SELECT max(r.roleId) FROM MarketPlaceRoles r")
	public int maxRoleId();
}