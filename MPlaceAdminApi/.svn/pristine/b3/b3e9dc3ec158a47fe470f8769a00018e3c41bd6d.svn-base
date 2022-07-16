package com.telemune.marketplace.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.ChargingLogs;

public interface ChargingLogsRepository extends JpaRepository<ChargingLogs, String> {

	Page<ChargingLogs> findByMsisdn(String msisdn, Pageable paging);

	List<ChargingLogs> findByMsisdn(String msisdn);

}
