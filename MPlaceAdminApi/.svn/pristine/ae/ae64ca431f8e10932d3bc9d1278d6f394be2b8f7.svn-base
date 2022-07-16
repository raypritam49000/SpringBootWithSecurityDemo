package com.telemune.marketplace.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.Pack;
import com.telemune.marketplace.rest.entity.PromoPack;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;
import com.telemune.marketplace.rest.entity.embedded.PromoPackIds;

/**
 * @author mayank
 *
 */
public interface PromoPackRepository  extends JpaRepository <PromoPack, PromoPackIds> {

	Page<PromoPack> findBystatus(String status, Pageable paging);

	List<PromoPack> findByPromoPackIdsPackId(Integer packId);

	void deleteAllByPromoPackIdsPackId(Integer packId);

	Optional<PromoPack> findByPromoPackIds(PromoPackIds promoPackIds);

	
	@Query(value = "SELECT max(p.promoPackIds.packId) FROM PromoPack p")
	public int maxPromoPackId();




	

	

	
	

}
