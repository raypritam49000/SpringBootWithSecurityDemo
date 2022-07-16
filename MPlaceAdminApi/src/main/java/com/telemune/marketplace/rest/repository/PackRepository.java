package com.telemune.marketplace.rest.repository;

import java.util.List;    
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.Pack;
import com.telemune.marketplace.rest.entity.embedded.PackIds;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;

public interface PackRepository extends JpaRepository<Pack, PackTypeIds> {
	
	List<Pack> findByPackIdsPackId(Integer string);

	Optional<Pack> findByPackIds(PackIds packIds);

	void deleteByPackIdsPackId(Integer id);
	
	@Query(value = "SELECT max(p.packIds.packId) FROM Pack p")
	public int maxPackId();

	void deleteAllByPackIdsPackId(Integer id);

	Optional<List<Pack>> findByPackTypeAndPackIdsLanguageId(Integer packTypeId, String valueOf);

	Page<Pack> findBystatus(String status, Pageable paging);

	Page<Pack>findByPackName(String query, Pageable paging);

	


	

	

	
}
