package com.telemune.marketplace.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.telemune.marketplace.rest.entity.TransactionCdr;

public interface TransactionCdrRepository extends JpaRepository<TransactionCdr, String> {

	Page<TransactionCdr> findByMsisdn(String msisdn, Pageable paging);

	List<TransactionCdr> findByMsisdn(String msisdn);

}
