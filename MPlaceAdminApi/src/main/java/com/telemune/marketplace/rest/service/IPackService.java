package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.PackPriority;
import com.telemune.marketplace.rest.entity.vo.PackVO;

/**
 * @author manjeet
 *
 */
public interface IPackService {

	/**
	 * @param id
	 * @param languageId
	 * @return
	 */
	public PackVO findByPackIdAndLanguageId(Integer id, String languageId);

	/**
	 * @param packVO
	 * @return
	 */
	public PackVO createPlan(PackVO packVO);

	/**
	 * @param packVO
	 * @return
	 */
	public PackVO updatePlan(PackVO packVO);

	/**
	 * @param id
	 * @return
	 */
	public List<PackVO> findById(Integer id);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public Pages findAllPlanWithPagination(Integer pageNo, Integer pageSize,String status,String packName);

	/**
	 * @param id
	 * @return
	 */
	public boolean planDeleteById(Integer id);

	/**
	 * @return
	 */
	public List<PackVO> findAllPlans();


	public List<Object> findAllPlanPriority(Integer packTypeId,
			Integer langId);

	public boolean updatePlanPriority(PackPriority packPriority);

}
