package com.telemune.marketplace.rest.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.assmbler.ModelToVOAssmbler;
import com.telemune.marketplace.rest.assmbler.VOToModelAssmbler;
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.PackType;
import com.telemune.marketplace.rest.entity.PromoPack;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;
import com.telemune.marketplace.rest.entity.embedded.PromoPackIds;
import com.telemune.marketplace.rest.entity.vo.PromoPackDetail;
import com.telemune.marketplace.rest.entity.vo.PromoPackVO;

import com.telemune.marketplace.rest.repository.PromoPackRepository;
import com.telemune.marketplace.rest.service.IPromoPackService;


/*
 * @author Mayank
 */
@Service
public class PromoPackServiceImpl implements IPromoPackService {
	

	@Autowired
	PromoPackRepository promoPackRepository;

	private static final Logger logger = Logger.getLogger(PackServiceImpl.class);

	@Override
	public Pages findAllPlanWithPagination(Integer pageNo, Integer pageSize, String status) {
		// TODO Auto-generated method stub

		logger.info("Inside findAllPlanWithPagination() method of PromoPackServiceImpl class");
		  Page<PromoPack> pagedResult = null;
		  Pageable paging = PageRequest.of(pageNo, pageSize);
		try {
			if (status!=null && !status.isEmpty() )
			{
				System.out.println("here is the status we get "+status);
				pagedResult = promoPackRepository.findBystatus(status, paging);
			}
			else{
			pagedResult = promoPackRepository.findAll(paging);
			
			}
			logger.debug(pagedResult.toString());

			List<Object> finalPromoPackVO = new ArrayList<>();
			if (pagedResult.hasContent()) {
				Pages pages = new Pages();
				pages.setTotalElements(pagedResult.getTotalElements());
				pages.setTotalPages(pagedResult.getTotalPages());
				List<PromoPack> promoPackdbList = pagedResult.getContent();
				
				for (PromoPack promoPack : promoPackdbList) {
					PromoPackVO promoPackVO = ModelToVOAssmbler.convertToPromoPackToPromoPackVo(promoPack);

					finalPromoPackVO.add(promoPackVO);
				}
				pages.setContent(finalPromoPackVO);
				logger.info("Exit findAllPlanWithPagination() method of PromoPackServiceImpl class");

				return pages;

			}

			else {
				logger.info("Exit findAllPlanWithPagination() method of PromoPackServiceImpl class");
				return new Pages();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Pages();
	

	
	}

	@Override
	@Transactional
	public boolean promoPlanDeleteById(Integer packId) {
		logger.info("inside promoPlanDeleteById() method of PromoPackServiceImpl class");

		List<PromoPack> promoPackdbList = promoPackRepository.findByPromoPackIdsPackId(packId);

		if (!promoPackdbList.isEmpty()) {
			try {

				promoPackRepository.deleteAllByPromoPackIdsPackId(packId);

				
			} catch (Exception exp) {
				exp.printStackTrace();

			}
			logger.info("Exit promoPlanDeleteById() method of PromoPackServiceImpl class");
			return true;
		}
		logger.info("Exit promoPlanDeleteById() method of PromoPackServiceImpl class");
		
		return false;
	}

	@Override
	public PromoPackVO findByPackIdAndLanguageId(Integer id, String languageId) {
		logger.info("Inside findByPackTypeIdAndLanguageId() method of PromoPackTypeServiceImpl class");

		Optional<PromoPack> promoPackdb = promoPackRepository.findByPromoPackIds(new PromoPackIds(id,languageId));
		logger.debug(promoPackdb.get().toString());
		if (promoPackdb.isPresent()) {
			return ModelToVOAssmbler.convertToPromoPackToPromoPackVo(promoPackdb.get());
		}
		logger.info("Exit findByPackTypeIdAndLanguageId() method of PackTypeServiceImpl class");

		return null;
	}

	@Override
	public List<PromoPackVO> findByPackId(Integer id) {
	List<PromoPackVO> finalPromoPackVO = new ArrayList<>();
		
		try{
		logger.info("Inside findById() method of PromoPackTypeServicelmpl class");
		

		List<PromoPack> promopackdbList = promoPackRepository.findByPromoPackIdsPackId(id);
		logger.debug(promopackdbList.toString());
		for (PromoPack promoPack : promopackdbList) {
			PromoPackVO promoPackVO = ModelToVOAssmbler.convertToPromoPackToPromoPackVo(promoPack);
			finalPromoPackVO.add(promoPackVO);
		}
		 logger.info("Exit findById() method of PromoPackTypeServicelmpl class");
		return finalPromoPackVO;
	   }catch (Exception exception) {
		   exception.printStackTrace();
		logger.info("Exit findById() method of PromoPackTypeServicelmpl class");
		
	  }
		return finalPromoPackVO;}

	@Override
	@Transactional
	public PromoPackVO createPromoPlan(PromoPackVO promoPackVO) {
		logger.info("Inside createPromoPlan() method of PromoPackServicelmpl class");
		System.out.print("inside create promoPlan method pf promoPackservice");
		int newPromoPackId = 1 + promoPackRepository.maxPromoPackId();

		System.out.println("PackId is =======>"+ newPromoPackId);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		PromoPack promoPack = null;
		
		PromoPack promoPackFinal = VOToModelAssmbler.convertToPromoPackVOToPromoPack(promoPackVO);
		try {
			
		
			for (PromoPackDetail ppd : promoPackVO.getPromoPackDetails()){
			
				
				//System.out.println("inside create plan method of createpromoPack "+promoPackVO.toString());
				
				System.out.println("packId is =====>>>" +promoPackVO.getPackId() );
				PromoPackIds promopackIds = new PromoPackIds();
				
				promopackIds.setLanguageId(String.valueOf(ppd.getLanguageId()));
				promoPackFinal.setProductCode(promoPackVO.getProductCode());;
				promoPackFinal.setSubType(promoPackVO.getSubType());;
				
				promopackIds.setPackId(newPromoPackId);
				promoPackFinal.setPackType(promoPackVO.getPackType());
				promoPackFinal.setCreateDate(date);
				promoPackFinal.setStatus(promoPackVO.getStatus());
				promoPackFinal.setPromoPackIds(promopackIds);
				promoPackFinal.setOther(promoPackVO.getOther());
				//promoPackFinal.setOther(promoPackVO.getOther());
				System.out.println("inside create plan method of promoPackFinal "+promoPackFinal.toString());


				promoPack = promoPackRepository.save(promoPackFinal);
			}
						
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);

		}
		logger.info("Exit createPromoPlan() method of PromoPackServicelmpl class");
		return ModelToVOAssmbler.convertToPromoPackToPromoPackVo(promoPack);

	}

	

	@Override
	@Transactional
	public PromoPackVO updatePromoPlan(PromoPackVO promoPackVO) {
		logger.info("Inside updatePromoPlan() method of PromoPackTypeServicelmpl class");
		PromoPack promoPack = null;
		System.out.println("inside the  update plan method "+promoPackVO.toString());
		try {
			for (PromoPackDetail ppd : promoPackVO.getPromoPackDetails()){
				System.out.println("inside try and for loop of update  method ");
				
				//List<PromoPack> promoPackdb = promoPackRepository.findByPromoPackIdsPackId(promoPackVO.getPackId());			
				Optional<PromoPack> promoPackdb = promoPackRepository.findByPromoPackIds(new PromoPackIds(promoPackVO.getPackId(), String.valueOf(ppd.getLanguageId())));
				
				System.out.println("here is the value we get =====>"+promoPackVO.getPackId());
				
				System.out.println("here is the value of "+promoPackdb.get().toString());
				
				if (promoPackdb.isPresent()) {
					System.out.println("inside if statement of promoPackdbupdate  method ");
				PromoPack promoPackFinal = VOToModelAssmbler.convertToPromoPackVOToPromoPack(promoPackVO,promoPackdb.get());

	
				promoPack = promoPackRepository.save(promoPackFinal);

				}
			
		}
			}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);
		}
		logger.info("Exit updatePlanType() method of PromoPackServicelmpl class");
		return ModelToVOAssmbler.convertToPromoPackToPromoPackVo(promoPack);

	}

	

	}

