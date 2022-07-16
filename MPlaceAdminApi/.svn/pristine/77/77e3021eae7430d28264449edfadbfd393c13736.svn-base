package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.LbsTemplateVO;

/**
 * @author manjeet
 *
 */
public interface ILbsTemplateService {

	/**
	 * <b> This method find the list of template </b>
	 * 
	 * @param id         This param define the id of template
	 * @param languageId This param define the languageId in template
	 * 
	 * @return LbsTemplateVO LbsTemplateVO object return of method
	 * 
	 */
	public LbsTemplateVO findByTemplateIdAndLanguageId(Integer id, Integer languageId);

	/**
	 * @param lbsTeplateVO
	 * @return
	 */
	public LbsTemplateVO updateTemplate(LbsTemplateVO lbsTeplateVO);

	/**
	 * @param id
	 * @return
	 */
	public List<LbsTemplateVO> findByTemplateId(Integer id);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pages findAllTmplateWithPagination(Integer pageNo, Integer pageSize, String langId, String query);

	/**
	 * @param id
	 * @return
	 */
	public boolean templateDeleteById(Integer id);

	/**
	 * @param id
	 * @return
	 */
	public List<LbsTemplateVO> findByLanguageId(Integer id);

	/**
	 * @return
	 */
	public List<LbsTemplateVO> findAllTemplate();

}
