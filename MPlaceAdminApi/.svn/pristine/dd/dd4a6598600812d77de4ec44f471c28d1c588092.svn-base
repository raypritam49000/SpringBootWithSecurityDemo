package com.telemune.marketplace.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.telemune.marketplace.rest.entity.PromoServiceMapping;
import com.telemune.marketplace.rest.entity.embedded.PromoService;
import com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO;

/**
 * @author mayank
 *
 */
public interface PromoServiceMapRepository extends CrudRepository <PromoServiceMapping,Long>  {

	
	
	//@Query("select scope ,count(*) count from promo_service_mapping p  group by p.scope")
	@Query("select new com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO(p.scope,count(p)) from PromoServiceMapping p  group by p.scope order by p.scope")
//	Page<PromoServiceMapping> findTotalCountByScope(Pageable paging);
	List<PromoServiceMapVO>findTotalCountByScope();
	
	@Query(value = "select * from  promo_service_mapping p where p.scope=?1", nativeQuery = true)
		List<Object[]> PromoDetail(String scope);

	

	List<PromoServiceMapping> findByPromoServiceMsisdn(String msisdn);

	

	void deleteAllByPromoServiceMsisdn(String msisdn);

	Optional<PromoServiceMapping> findByPromoService(PromoService promoService);

	List<PromoServiceMapping> findByScope(String scope);
	@Transactional
	@Modifying
	@Query(value = "update promo_service_mapping  set scope=? where scope=?", nativeQuery = true)
	 int updateByScope(String scope,String oldScope);

	 void deleteAllByScope(String scope);

	

	


	
	
}
