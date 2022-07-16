package com.telemune.marketplace.rest.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.telemune.marketplace.rest.assmbler.ModelToVOAssmbler;
import com.telemune.marketplace.rest.assmbler.VOToModelAssmbler;
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.PromoPack;
import com.telemune.marketplace.rest.entity.WhiteBlackList;
import com.telemune.marketplace.rest.entity.embedded.PromoPackIds;
import com.telemune.marketplace.rest.entity.embedded.WhiteBlack;
import com.telemune.marketplace.rest.entity.vo.PromoPackDetail;
import com.telemune.marketplace.rest.entity.vo.WhiteBlackVO;
import com.telemune.marketplace.rest.repository.WhiteBlackRepository;
import com.telemune.marketplace.rest.service.IWhiteBlackService;
import com.telemune.marketplace.rest.utility.CommonUtility;


/*
 * @author mayank
 */


@Service
public class WhiteBlackServiceImpl implements IWhiteBlackService {
	
	@Autowired
	WhiteBlackRepository whiteBlackRepository;
	
	//private List<WhiteBlackVO> whiteBlackVoLst;
	
	private static final Logger logger = Logger.getLogger(WhiteBlackServiceImpl.class);
	
	@Override
	public Pages findAllListWithPagination(Integer pageNo, Integer pageSize,String type,String msisdn) {

		Page<WhiteBlackList> pagedResult = null;
		Pageable paging = PageRequest.of(pageNo, pageSize);

		logger.info("Inside findAllListWithPagination() method of WhiteBlackServiceImpl class");
		System.out.println("inside the findAllListWithPagination method");
		try {
			if (type!=null && !type.isEmpty() )
		{
			System.out.println("here is the status we get "+type);
			pagedResult = whiteBlackRepository.findBytype(type, paging);
		}
		else if(msisdn!=null && !msisdn.isEmpty())
		{
			pagedResult = whiteBlackRepository.findByWhiteBlackMsisdn(msisdn,paging);
		}else{
	
	
			pagedResult = whiteBlackRepository.findAll(paging);
		}

		List<Object> whiteBlackVOlst = new ArrayList<>();
		
		logger.debug(pagedResult);

		if (pagedResult.hasContent()) {
			Pages pages = new Pages();
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());

			List<WhiteBlackList> whiteBlackdbList = pagedResult.getContent();
			for (WhiteBlackList wbl : whiteBlackdbList) {
				WhiteBlackVO wblVO = ModelToVOAssmbler.convertToWhiteBlackToWhiteBlackVo(wbl);
				whiteBlackVOlst.add(wblVO);
			}
			pages.setContent(whiteBlackVOlst);
			logger.info("Exit findAllListWithPagination() method of WhiteBlackServiceImpl class");
			return pages;

		} else {
			logger.info("Exit findAllListWithPagination() method of WhiteBlackServiceImpl class");
			return new Pages();
		}}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Pages();
		
	}

	@Override
	public List<WhiteBlackVO> findByMsisdn(String msisdn) {
       List<WhiteBlackVO> finalWhiteBlackVO = new ArrayList<>();
		
		try{
		logger.info("Inside findByMsisdn() method of PackTypeServicelmpl class");
		

		List<WhiteBlackList> whiteBlackdbList = whiteBlackRepository.findByWhiteBlackMsisdn(msisdn);
		logger.debug(whiteBlackdbList.toString());
		for (WhiteBlackList wbl : whiteBlackdbList) {
			WhiteBlackVO whiteBlackVO = ModelToVOAssmbler.convertToWhiteBlackToWhiteBlackVo(wbl);
			finalWhiteBlackVO.add(whiteBlackVO);
		}
		logger.info("Exit findByMsisdn() method of WhiteBlackServiceImpl class");
		return finalWhiteBlackVO;
	   }catch (Exception exception) {
		   exception.printStackTrace();
		logger.info("Exit findByMsisdn() method of WhiteBlackServiceImpl class");
		
	  }
		return finalWhiteBlackVO;}

	@Override
	@Transactional
	public boolean DeleteByMsisdn(String msisdn) {
		// TODO Auto-generated method stub
		
		logger.info("inside DeleteByMsisdn() method of WhiteBlackServiceImpl class");
		try{
		System.out.println("inside delete by msisdn method"+msisdn);
		List<WhiteBlackList> whiteBlackdbList = whiteBlackRepository.findByWhiteBlackMsisdn(msisdn);
		//System.out.println(" delete by msisdn method"+msisdn);
		if (!whiteBlackdbList.isEmpty()) {
			try {

				whiteBlackRepository.deleteAllByWhiteBlackMsisdn(msisdn);

			} catch (Exception exp) {
				exp.printStackTrace();

			}
			logger.info("Exit DeleteByMsisdn() method of WhiteBlackServiceImpl class");
			return true;
		}
		logger.info("Exit DeleteByMsisdn() method of WhiteBlackServiceImpl class");
		} catch (Exception exp) {
			exp.printStackTrace();

		}
		return false;
	}

	
	@Override
	@Transactional
	public WhiteBlackVO updateList(WhiteBlackVO whiteBlackVO) {
		logger.info("Inside updateList() method of WhiteBlackServiceImpl class");
		WhiteBlackList whiteBlackList = null;
		System.out.println("inside the  updateList method "+whiteBlackVO.toString());
		try {
		
				System.out.println("inside try and for loop of update  method ");
				
				//List<PromoPack> promoPackdb = promoPackRepository.findByPromoPackIdsPackId(promoPackVO.getPackId());			
				Optional<WhiteBlackList> WhiteBlackListdb = whiteBlackRepository.findByWhiteBlack(new WhiteBlack(whiteBlackVO.getMsisdn()));
				
				System.out.println("here is the value we get =====>"+whiteBlackVO.getMsisdn());
				
				System.out.println("here is the value of "+WhiteBlackListdb.get().toString());
				
				if (WhiteBlackListdb.isPresent()) {
					System.out.println("inside if statement of updateList  method ");
					WhiteBlackList whiteBlackListFinal = VOToModelAssmbler.convertToWhiteBlackVOToWhiteBlack(whiteBlackVO,WhiteBlackListdb.get());

	
					whiteBlackList = whiteBlackRepository.save(whiteBlackListFinal);

				}
			
		
			}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);
		}
		logger.info("Exit updatePlanType() method of WhiteBlackServiceImpl class");
		return ModelToVOAssmbler.convertToWhiteBlackToWhiteBlackVo(whiteBlackList);

	}

	@Override
	public WhiteBlackVO addMsisdn(WhiteBlackVO whiteBlackVO) {
		// TODO Auto-generated method stub
		logger.info("Inside addMsisdn() method of WhiteBlackServiceImpl class");
		System.out.print("inside add Msisdn method pf WhiteBlackService");
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		WhiteBlackList whiteBlackList = null;
		
		WhiteBlackList whiteBlackListFinal = VOToModelAssmbler.convertToWhiteBlackVOToWhiteBlack(whiteBlackVO);
		try {
			
		//System.out.println("inside create plan method of createpromoPack "+promoPackVO.toString());
			WhiteBlack whiteBlack = new WhiteBlack();
				
			     whiteBlack.setMsisdn(whiteBlackVO.getMsisdn());
			     whiteBlackListFinal.setWhiteBlack(whiteBlack);
			    whiteBlackListFinal.setType(whiteBlackVO.getType());;
				whiteBlackListFinal.setCreateDate(date);
			
				//promoPackFinal.setOther(promoPackVO.getOther());
				System.out.println("inside add Method od WhiteBlackList "+whiteBlackListFinal.toString());


				whiteBlackList = whiteBlackRepository.save(whiteBlackListFinal);
			
						
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);

		}
		logger.info("Exit addMsisdn() method of WhiteBlackServiceImpl class");
		return ModelToVOAssmbler.convertToWhiteBlackToWhiteBlackVo(whiteBlackList);

	}


}