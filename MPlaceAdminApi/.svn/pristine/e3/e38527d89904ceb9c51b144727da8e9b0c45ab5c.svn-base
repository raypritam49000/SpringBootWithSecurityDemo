package com.telemune.marketplace.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.telemune.marketplace.rest.entity.WhiteBlackList;
import com.telemune.marketplace.rest.entity.embedded.WhiteBlack;

/**
 * @author mayank
 *
 */
public interface WhiteBlackRepository extends JpaRepository <WhiteBlackList,WhiteBlack> 

{
	

	/*@Query(value = "SELECT count(TYPE) FROM WhiteBlackList where Type=B")
	public int blackCount();
	
	@Query(value = "SELECT count(TYPE) FROM WhiteBlackList where Type=W")
	public int whiteCount();*/

	List<WhiteBlackList> findByWhiteBlackMsisdn(String msisdn);

	void deleteAllByWhiteBlackMsisdn(String msisdn);

	Page<WhiteBlackList> findBytype(String type, Pageable paging);

	Page<WhiteBlackList> findByWhiteBlackMsisdn(String msisdn, Pageable paging);

	Optional<WhiteBlackList> findByWhiteBlack(WhiteBlack whiteBlack);

//	@Query(value = "SELECT count(TYPE) FROM WhiteBlackList where Type=W")
	//public Page<WhiteBlackList> whiteCount(Pageable paging);
	
//	@Query(value = "SELECT count(TYPE) FROM WhiteBlackList where Type=B")
	//public Page<WhiteBlackList> blackCount(Pageable paging);

	//List<WhiteBlackList> findByType(String type);
 
}
