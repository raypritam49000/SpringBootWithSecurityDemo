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
import com.telemune.marketplace.rest.entity.Pack;
import com.telemune.marketplace.rest.entity.PackType;
import com.telemune.marketplace.rest.entity.embedded.PackIds;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;
import com.telemune.marketplace.rest.entity.vo.PackTypeDetail;
import com.telemune.marketplace.rest.entity.vo.PackTypeVO;
import com.telemune.marketplace.rest.entity.vo.TransferValidityDetail;
import com.telemune.marketplace.rest.repository.PackTypeRepository;
import com.telemune.marketplace.rest.service.IPackTypeService;


@Service
public class IPackTypeServiceImpl implements IPackTypeService {

	@Autowired
	PackTypeRepository packTypeRepository;
	private static final Logger logger = Logger.getLogger(PackServiceImpl.class);
	@Override
	public PackTypeVO findByPackTypeIdAndLanguageId(Integer id, String languageId) {
		logger.info("Inside findByPackTypeIdAndLanguageId() method of PackTypeServiceImpl class");

		Optional<PackType> packdb = packTypeRepository.findByPackTypeIds(new PackTypeIds(id, languageId));
		logger.debug(packdb.get().toString());
		if (packdb.isPresent()) {
			return ModelToVOAssmbler.convertToPackTypeToPackTypeVo(packdb.get());
		}
		logger.info("Exit findByPackTypeIdAndLanguageId() method of PackTypeServiceImpl class");

		return null;
	}

	@Override
	public PackTypeVO createPlanType(PackTypeVO packTypeVO) {
		logger.info("Inside createPlanType() method of PackTypeServicelmpl class");
		System.out.print("inside create plan method pf packtypeservice");
		int newPackTypeId = 1 + packTypeRepository.maxPackTypeId();

		System.out.println(newPackTypeId);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		PackType packType = null;
		
		PackType packTypeFinal = VOToModelAssmbler.convertToPackTypeVOToPackType(packTypeVO);
		try {
			
		
			for (PackTypeDetail ptd : packTypeVO.getPackTypeDetails()){
			//for (int i = 0; i < languageIdlst.length; i++) {
				
				System.out.print("inside create plan method of createpacktype "+packTypeVO.toString());

				PackTypeIds packTypeIds = new PackTypeIds();
				packTypeIds.setLanguageId(String.valueOf(ptd.getLanguageId()));
				packTypeIds.setPackTypeId(newPackTypeId);
				packTypeFinal.setPackTypeIds(packTypeIds);
				packTypeFinal.setBasePackType(packTypeVO.getBasePackType());
				packTypeFinal.setPackTypePrompt(packTypeVO.getPackTypePrompt());
				packTypeFinal.setPriority(packTypeVO.getPriority());
				packTypeFinal.setSuperPackType(packTypeVO.getSuperPackType());
				packTypeFinal.setPackTypeName(String.valueOf(ptd.getPackTypeName()));
				packTypeFinal.setDescription(String.valueOf(ptd.getDescription()));
				packTypeFinal.setParallelPackEnable(packTypeVO.getParallelPackEnable());
				packTypeFinal.setSTATUS(packTypeVO.getStatus());
		     	


				packType = packTypeRepository.save(packTypeFinal);
			}
						
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);

		}
		logger.info("Exit createPlanType() method of PackTypeServicelmpl class");
		return ModelToVOAssmbler.convertToPackTypeToPackTypeVo(packType);

	}

	@Override
	@Transactional
	public PackTypeVO updatePlanType(PackTypeVO packTypeVO) {
		logger.info("Inside updatePlanType() method of PackTypeServicelmpl class");
		PackType packType = null;
		System.out.println("inside the  update plan method "+packTypeVO.toString());
		try {
			for (PackTypeDetail ptd : packTypeVO.getPackTypeDetails()){
				System.out.println("inside try and for loop of update  method ");
				Optional<PackType> packTypedb = packTypeRepository.findByPackTypeIds(new PackTypeIds(packTypeVO.getPackType(), String.valueOf(ptd.getLanguageId())));
				logger.debug(packTypedb.get().toString());
				System.out.println("here is the value of packtypedb===="+packTypedb.get().toString());
				if (packTypedb.isPresent()) {
					System.out.println("inside if statement of packTypedbupdate  method ");
				PackType packTypeFinal = VOToModelAssmbler.convertToPackTypeVOToPackType(packTypeVO,packTypedb.get());

				
		  packTypeFinal.setPackTypeName(ptd.getPackTypeName());
	      packTypeFinal.setDescription(ptd.getDescription());
			packType = packTypeRepository.save(packTypeFinal);

				}
			
		}
			}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);
		}
		logger.info("Exit updatePlanType() method of PackTypeServicelmpl class");
		return ModelToVOAssmbler.convertToPackTypeToPackTypeVo(packType);

	}

	@Override
	public List<PackTypeVO> findById(Integer id) {
		List<PackTypeVO> finalPackVO = new ArrayList<>();
		
		try{
		logger.info("Inside findById() method of PackTypeServicelmpl class");
		

		List<PackType> packdbList = packTypeRepository.findByPackTypeIdsPackTypeId(id);
		logger.debug(packdbList.toString());
		for (PackType pk : packdbList) {
			PackTypeVO packVO = ModelToVOAssmbler.convertToPackTypeToPackTypeVo(pk);
			finalPackVO.add(packVO);
		}
		logger.info("Exit findById() method of PackTypeServicelmpl class");
		return finalPackVO;
	   }catch (Exception exception) {
		   exception.printStackTrace();
		logger.info("Exit findById() method of PackTypeServicelmpl class");
		
	  }
		return finalPackVO;}

	@Override
	public Pages findAllPlanTypeWithPagination(Integer pageNo, Integer pageSize,String status) {
		logger.info("Inside findAllPlanTypeWithPagination() method of PackTypeServicelmpl class");
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<PackType> pagedResult = null;
		try{
		if (status!=null && !status.isEmpty())
		{
			System.out.println("here is the status we get "+status);
			pagedResult = packTypeRepository.findBySTATUS(status, paging);
		
		}
		else{
			
	   pagedResult = packTypeRepository.findAll(paging);
	   
		}
		logger.debug(pagedResult.toString());

		
		List<PackTypeVO> finalPackVO = new ArrayList<>();
		if (pagedResult.hasContent()) {
			Pages pages = new Pages();
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());
			List<PackType> packdbList = pagedResult.getContent();
			for (PackType pk : packdbList) {
				PackTypeVO packVO = ModelToVOAssmbler.convertToPackTypeToPackTypeVo(pk);
			
				finalPackVO.add(packVO);
			}
			pages.setContent(finalPackVO);
			return pages;

		} else {
			logger.info("Exit findAllPlanTypeWithPagination() method of PackTypeServicelmpl class");
			return new Pages();
			}
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Pages();
		
	}

	@Override
	@Transactional
	public boolean PlanDeleteById(Integer id) {
		logger.info("Inside PlanDeleteById() method of PackTypeServicelmpl class");
		List<PackType> packTypedbList = packTypeRepository.findByPackTypeIdsPackTypeId(id);
	
		if(!packTypedbList.isEmpty())
		{
		try{
		
		packTypeRepository.deleteByPackTypeIdsPackTypeId(id);
		}
         	
	 catch (Exception exp) {
			exp.printStackTrace();
	    }
	    logger.info("Exit planDeleteById() method of PackTypeServiceImpl class");
		return true;
	   } 
	    logger.info("Exit planDeleteById() method of PackServiceImpl class");
	    return false;
       } 

	@Override
	public List<PackTypeVO> findAllPlanType() {
		logger.info("Inside findAllPlanType() method of PackTypeServicelmpl class");

		List<PackTypeVO> finalPackTypeVO = new ArrayList<>();
		List<PackType> packTypedbList = packTypeRepository.findAll();

		for (PackType pk : packTypedbList) {
			PackTypeVO packVO = ModelToVOAssmbler.convertToPackTypeToPackTypeVo(pk);
			finalPackTypeVO.add(packVO);
		}
		logger.info("Exit findAllPlanType() method of PackTypeServicelmpl class");

		return finalPackTypeVO;
	}

	@Override
	public List<PackTypeVO> findAllPlanTypeByLanguage(String languageId) {
		List<PackTypeVO> finalPackVO = new ArrayList<>();
		logger.info("Inside findAllPlanTypeLanguage() method of PackTypeServicelmpl class");

		List<PackType> packdbList = packTypeRepository.findByPackTypeIdsLanguageId(languageId);

		for (PackType pk : packdbList) {
			PackTypeVO packVO = ModelToVOAssmbler.convertToPackTypeToPackTypeVo(pk);
			finalPackVO.add(packVO);
		}
		logger.info("Exit findAllPlanTypeLanguage() method of PackTypeServicelmpl class");

		return finalPackVO;
	}

	
}
