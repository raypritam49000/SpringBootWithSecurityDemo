package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.PromoPackVO;
/**
 * @author mayank
 *
 */
public interface IPromoPackService {
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public Pages findAllPlanWithPagination(Integer pageNo, Integer pageSize, String status);

	/**
	 * @param id
	 * @return
	 */
	public boolean promoPlanDeleteById(Integer packId);

	/**
	 * @param id
	 * @param languageId
	 * @return
	 */
	public PromoPackVO findByPackIdAndLanguageId(Integer id, String languageId);

	/**
	 * @param id
	 * @return
	 */
	public List<PromoPackVO> findByPackId(Integer id);
	/**
	 * @param promoPackVO
	 * @return
	 */
	public PromoPackVO createPromoPlan(PromoPackVO promoPackVO);
	/**
	 * @param promoPackVO
	 * @return
	 */
	public PromoPackVO updatePromoPlan(PromoPackVO promoPackVO);

}
