package com.telemune.marketplace.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.ServiceChargeDetail;


public interface DescServiceChargeDetailRepository extends JpaRepository<ServiceChargeDetail,Integer>{

	Optional<ServiceChargeDetail> findByPackId(Integer packId);

	void deleteAllByPackId(Integer id);

}
