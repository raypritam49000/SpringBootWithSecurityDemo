package com.telemune.marketplace.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemune.marketplace.rest.entity.MarketPlaceAdminUser;

import java.util.Optional;

/**
 *Manjeet
 */
@Repository 
public interface MarketPlaceAdminUserRepository extends JpaRepository<MarketPlaceAdminUser, String> {
  
	Optional<MarketPlaceAdminUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

	void deleteByUsername(String username);
}
