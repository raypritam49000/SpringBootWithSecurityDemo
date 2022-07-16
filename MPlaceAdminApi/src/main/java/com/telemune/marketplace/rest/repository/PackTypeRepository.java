package com.telemune.marketplace.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.PackType;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;

public interface PackTypeRepository extends JpaRepository<PackType, PackTypeIds> {

	Optional<PackType> findByPackTypeIds(PackTypeIds packTypeIds);

	@Query(value = "SELECT max(p.packTypeIds.packTypeId) FROM PackType p")
	public int maxPackTypeId();

	void deleteByPackTypeIdsPackTypeId(Integer id);

	List<PackType> findByPackTypeIdsPackTypeId(Integer id);

	List<PackType> findByPackTypeIdsLanguageId(String languageId);

	Page<PackType> findBySTATUS(String status, Pageable paging);

	

}
