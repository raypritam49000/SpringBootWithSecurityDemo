package com.telemune.marketplace.rest.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO;

/**
 * @author mayank
 *
 */
public interface IPromoServiceMap {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	List<PromoServiceMapVO> findAllCountWithPagination();

	List<PromoServiceMapVO> promoServiceReportCsv(String scope);

	

	boolean promoDeleteMsisdn(String msisdn);

	PromoServiceMapVO updatePromoService(PromoServiceMapVO promoServiceMapVO);

	PromoServiceMapVO addMsisdn(PromoServiceMapVO promoServiceMapVO);

	List<PromoServiceMapVO> findByMsisdn(String msisdn);

	List<PromoServiceMapVO> findByScope(String scope);

	List <PromoServiceMapVO> updatePromoServiceScope(PromoServiceMapVO promoServiceMapVO);


	boolean store(MultipartFile file, PromoServiceMapVO promoServiceMapVO, HttpSession session);

	
	boolean deleteScope(String scope);

	

	
 
	
	
	
}
