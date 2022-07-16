package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.PackTypeVO;

/**
 * @author manjeet
 *
 */
public interface IPackTypeService {
	
	
	/**
	 * @param id
	 * @param languageId
	 * @return
	 */
	public PackTypeVO findByPackTypeIdAndLanguageId(Integer id, String languageId);

	/**
	 * @param packTypeVO
	 * @return
	 */
	public PackTypeVO createPlanType(PackTypeVO packVO);

	/**
	 * @param packVO
	 * @return
	 */
	public PackTypeVO updatePlanType(PackTypeVO packVO);

	/**
	 * @param id
	 * @return
	 */
	public List<PackTypeVO> findById(Integer id);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public Pages findAllPlanTypeWithPagination(Integer pageNo, Integer pageSize,String status);

	/**
	 * @param id
	 * @return
	 */
	public boolean PlanDeleteById(Integer id);

	/**
	 * @return
	 */
	public List<PackTypeVO> findAllPlanType();

	public List<PackTypeVO> findAllPlanTypeByLanguage(String languageId);

}
