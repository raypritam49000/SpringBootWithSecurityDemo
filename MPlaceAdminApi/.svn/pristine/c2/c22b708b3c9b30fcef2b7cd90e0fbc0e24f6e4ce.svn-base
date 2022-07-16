package com.telemune.marketplace.rest.service;

import java.text.ParseException;
import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.WhiteBlackVO;

/**
 * @author mayank
 *
 */
public interface IWhiteBlackService {
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public Pages findAllListWithPagination(Integer pageNo, Integer pageSize,String type,String msisdn);

	/**
	 * @param msisdn
	 * @return
	 */
	public List<WhiteBlackVO> findByMsisdn(String msisdn);
	/**
	 * @param msisdn
	 * @return
	 */
	public boolean DeleteByMsisdn(String msisdn);

	/**
	 * @param whiteBlackVO
	 * @return
	 */
	public WhiteBlackVO updateList(WhiteBlackVO whiteBlackVO);
	/**
	 * @param whiteBlackVO
	 * @return
	 */
	public WhiteBlackVO addMsisdn(WhiteBlackVO whiteBlackVO);

	/**
	 * @param whiteBlackVO
	 * @return
	 */
	//public WhiteBlackVO addMsisdn(WhiteBlackVO whiteBlackVO);

//	public Pages findWhiteBlackCount(Integer pageNo, Integer pageSize, String sortBy, String query);

//	public List<WhiteBlackVO> csvFiledateForDownload(String type)throws ParseException;

}
