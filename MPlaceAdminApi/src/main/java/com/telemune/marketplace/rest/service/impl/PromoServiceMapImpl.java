package com.telemune.marketplace.rest.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.telemune.marketplace.rest.assmbler.ModelToVOAssmbler;
import com.telemune.marketplace.rest.assmbler.VOToModelAssmbler;
import com.telemune.marketplace.rest.entity.PromoServiceMapping;
import com.telemune.marketplace.rest.entity.embedded.PromoService;
import com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO;
import com.telemune.marketplace.rest.repository.PromoServiceMapRepository;
import com.telemune.marketplace.rest.service.IPromoServiceMap;


/*
 * @Author Mayank
 */
@Service
public class PromoServiceMapImpl implements IPromoServiceMap{

	
	@Autowired
	PromoServiceMapRepository promoServiceMapRepository;
	
	private List<PromoServiceMapVO> promoServiceMapVOlst;
	
	private static final Logger logger = Logger.getLogger(IPromoServiceMap.class);

	@Override
	public List<PromoServiceMapVO> findAllCountWithPagination() {
		List<PromoServiceMapVO> promoServiceMappingdb=null;
		try {	// TODO Auto-generated method stub
			System.out.println("inside the try of findAllCountWithPagination() method of PromoServiceMapImpl class ");

		logger.info("Inside findAllCountWithPagination() method of PromoServiceMapImpl class");
		System.out.println("inside the findAllCountWithPagination() method of PromoServiceMapImpl class ");
		
			System.out.println("inside the try of findAllCountWithPagination() method of PromoServiceMapImpl class ");
			promoServiceMappingdb=promoServiceMapRepository.findTotalCountByScope();
			 for (int i = 0; i < promoServiceMappingdb.size(); i++) {
		            PromoServiceMapVO promoServiceMapVO=promoServiceMappingdb.get(i);
		            promoServiceMapVO.setOldScope(promoServiceMapVO.getScope());
		            

		        }
		
			System.out.println("here is the promoservicedb"+promoServiceMappingdb);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return promoServiceMappingdb;
	

	
	}

	@Override
	public List<PromoServiceMapVO> promoServiceReportCsv(String scope) {
		// TODO Auto-generated method stub
		logger.info("Inside promoServiceReportCsv() method of PromoServiceMapImpl class");

		List<Object[]> promoServiceMapdb = promoServiceMapRepository.PromoDetail(scope);

		logger.debug(promoServiceMapdb.toString());
		
		System.out.println("Here is the date"+scope);
		System.out.println("Here is the db"+promoServiceMapdb);

		promoServiceMapVOlst = new ArrayList<>();
		for (Object[] paa : promoServiceMapdb) {	

			PromoServiceMapVO promoServiceMapVO = new PromoServiceMapVO();

			promoServiceMapVO.setMsisdn(String.valueOf(paa[0]));
			promoServiceMapVO.setScope(String.valueOf(paa[1]));
			

			promoServiceMapVOlst.add(promoServiceMapVO);
		}
		System.out.println("Here is the list"+promoServiceMapVOlst.toString());
		logger.info("Exit promoServiceReportCsv() method of PromoServiceMapImpl class");
		return promoServiceMapVOlst;

	}

	

	@Override
	@Transactional
	public boolean promoDeleteMsisdn(String msisdn) {
		// TODO Auto-generated method stub
		logger.info("inside promoDeleteMsisdn() method of PromoPackServiceImpl class");

			List<PromoServiceMapping> promoServiceMapList = promoServiceMapRepository.findByPromoServiceMsisdn(msisdn);

			if (!promoServiceMapList.isEmpty()) {
				try {

					promoServiceMapRepository.deleteAllByPromoServiceMsisdn(msisdn);

					
				} catch (Exception exp) {
					exp.printStackTrace();

				}
				logger.info("Exit promoDeleteMsisdn() method of PromoPackServiceImpl class");
				return true;
			}
			logger.info("Exit promoDeleteMsisdn() method of PromoPackServiceImpl class");
			
			return false;
		}

	@Override
	@Transactional
	public PromoServiceMapVO updatePromoService(PromoServiceMapVO promoServiceMapVO) {
		// TODO Auto-generated method stub
		logger.info("Inside updatePromoService() method of PromoPackServiceImpl class");
		PromoServiceMapping promoServiceMapping = null;
		System.out.println("inside the  update promo method "+promoServiceMapVO.toString());
		try {
			
				System.out.println("inside try and for loop of update  method ");
				
				//List<PromoPack> promoPackdb = promoPackRepository.findByPromoPackIdsPackId(promoPackVO.getPackId());			
				Optional<PromoServiceMapping> promoServiceMappingdb = promoServiceMapRepository.findByPromoService(new PromoService(promoServiceMapVO.getMsisdn()));
				
				System.out.println("here is the value we get =====>"+promoServiceMapVO.getMsisdn());
				
				System.out.println("here is the value of "+promoServiceMappingdb.get().toString());
				
				if (promoServiceMappingdb.isPresent()) {
					System.out.println("inside if statement of updatePromoService  method ");
					PromoServiceMapping promoServiceMappingFinal = VOToModelAssmbler.convertToPromoServiceMapVOToPromoServiceMap(promoServiceMapVO,promoServiceMappingdb.get());

	
					promoServiceMapping = promoServiceMapRepository.save(promoServiceMappingFinal);

				}
			
		
			}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);
		}
		logger.info("Exit updatePlanType() method of PromoPackServicelmpl class");
		return ModelToVOAssmbler.convertToPromoServiceMapToPromoServiceMapVo(promoServiceMapping);

	}

	@Override
	public PromoServiceMapVO addMsisdn(PromoServiceMapVO promoServiceMapVO) {
		// TODO Auto-generated method stub
		logger.info("Inside addMsisdn() method of PromoPackServicelmpl class");
		System.out.print("inside add Msisdn method PromoPackServicelmpl");
		
		PromoServiceMapping promoServiceMapping = null;
		
		PromoServiceMapping promoServiceMappingFinal = VOToModelAssmbler.convertToPromoServiceMapVOToPromoServiceMap(promoServiceMapVO);
		try {
			
		//System.out.println("inside create plan method of createpromoPack "+promoPackVO.toString());
			PromoService promoService = new PromoService();
				
			   promoService.setMsisdn(promoServiceMapVO.getMsisdn());
			   promoServiceMappingFinal.setPromoService(promoService);
			   promoServiceMappingFinal.setScope(promoServiceMapVO.getScope());
	
			
				//promoPackFinal.setOther(promoPackVO.getOther());
				System.out.println("inside Add Method of promoService "+promoServiceMappingFinal.toString());


				promoServiceMapping = promoServiceMapRepository.save(promoServiceMappingFinal);
			
						
		}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);

		}
		logger.info("Exit addMsisdn() method of PromoPackServicelmpl class");
		return ModelToVOAssmbler.convertToPromoServiceMapToPromoServiceMapVo(promoServiceMapping);

	}

	@Override
	public List<PromoServiceMapVO> findByMsisdn(String msisdn) {
		// TODO Auto-generated method stub
	List<PromoServiceMapVO> finalPromoServiceMapVO = new ArrayList<>();
		
		try{
		logger.info("Inside findByMsisdn() method of PromoPackServicelmpl class");
		

		List<PromoServiceMapping> promoServiceMappingdbList = promoServiceMapRepository.findByPromoServiceMsisdn(msisdn);
		logger.debug(promoServiceMappingdbList.toString());
		for (PromoServiceMapping pk : promoServiceMappingdbList) {
			PromoServiceMapVO promoServiceMapVO = ModelToVOAssmbler.convertToPromoServiceMapToPromoServiceMapVo(pk);
			finalPromoServiceMapVO.add(promoServiceMapVO);
		}
		logger.info("Exit findByMsisdn() method of PromoPackServicelmpl class");
		return finalPromoServiceMapVO;
	   }catch (Exception exception) {
		   exception.printStackTrace();
		logger.info("Exit findByMsisdn() method of PromoPackServicelmpl class");
		
	  }
		return finalPromoServiceMapVO;
		}

	@Override
	public List<PromoServiceMapVO> findByScope(String scope) {
		// TODO Auto-generated method stub
		List<PromoServiceMapVO> finalPromoServiceMapVO = new ArrayList<>();
			
			try{
			logger.info("Inside findByScope() method of PromoPackServicelmpl class");
			

			List<PromoServiceMapping> promoServiceMappingdbList = promoServiceMapRepository.findByScope(scope);
			logger.debug(promoServiceMappingdbList.toString());
			for (PromoServiceMapping pk : promoServiceMappingdbList) {
				PromoServiceMapVO promoServiceMapVO = ModelToVOAssmbler.convertToPromoServiceMapToPromoServiceMapVo(pk);
				finalPromoServiceMapVO.add(promoServiceMapVO);
			}
			logger.info("Exit findByScope() method of PromoPackServicelmpl class");
			return finalPromoServiceMapVO;
		   }catch (Exception exception) {
			   exception.printStackTrace();
			logger.info("Exit findByScope() method of PromoPackServicelmpl class");
			
		  }
			return finalPromoServiceMapVO;
			}

	

	@Override
	public List<PromoServiceMapVO> updatePromoServiceScope(PromoServiceMapVO promoServiceMapVO) {
		// TODO Auto-generated method stub
		logger.info("Inside updatePromoServiceScope() method of PromoPackServiceImpl class");
		List<PromoServiceMapVO> promoServiceMap = null;
		System.out.println("inside the  updatePromoServiceScope "+promoServiceMapVO.toString());
		try {
			
				System.out.println("inside try and for loop of update  method ");
				//<PromoServiceMapping> promoServiceMappingdb = promoServiceMapRepository.findByScope(promoServiceMapVO.setOldScope(promoServiceMapVO.getScope()));
				 promoServiceMapRepository.updateByScope(promoServiceMapVO.getScope(),promoServiceMapVO.getOldScope());

				 promoServiceMap= findAllCountWithPagination();
				System.out.println("here is the value we get =====>"+promoServiceMapVO.getScope());
							
				}catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);
		}
		logger.info("Exit updatePlanType() method of PromoPackServicelmpl class");
		return promoServiceMap;

	}

	@Override
	public boolean store(MultipartFile file, PromoServiceMapVO promoServiceMapVO, HttpSession session) {
		// TODO Auto-generated method stub
		try{

		 PromoServiceMapping promoServiceMapping = new PromoServiceMapping();
		 
		
		  byte[] bytes = file.getBytes();
		    String completeData = new String(bytes);
		    System.out.println("here is the msis"+completeData);
		    
		     String[] temp = completeData.split("\n|,");
         
		     
           for(int i=0;i<temp.length;i++)
          {
        	PromoService promoService = new PromoService();
           promoService.setMsisdn(temp[i]);
           System.out.println("here is the msis"+temp[i]);
           System.out.println("toString" + promoService.toString());
           promoServiceMapping.setPromoService(promoService);
		   promoServiceMapping.setScope(promoServiceMapVO.getScope());
           System.out.println("here is the scope"+promoServiceMapVO.getScope());
           promoServiceMapRepository.save(promoServiceMapping);
		     }
		    
           
            
	}catch (IOException e)
    {
        e.printStackTrace();
    }
      return true;
	}

	@Override
	@Transactional
	public boolean deleteScope(String scope) {
		// TODO Auto-generated method stub
			logger.info("inside promoDeleteScope() method of PromoPackServiceImpl class");

		List<PromoServiceMapping> promoServiceMapList = promoServiceMapRepository.findByScope(scope);

				if (!promoServiceMapList.isEmpty()) {
					try {

						promoServiceMapRepository.deleteAllByScope(scope);

						
					} catch (Exception exp) {
						exp.printStackTrace();

					}
					logger.info("Exit promoDeleteScope() method of PromoPackServiceImpl class");
					return true;
				}
				logger.info("Exit promoDeleteScope() method of PromoPackServiceImpl class");
				
				return false;
			}

	
}
