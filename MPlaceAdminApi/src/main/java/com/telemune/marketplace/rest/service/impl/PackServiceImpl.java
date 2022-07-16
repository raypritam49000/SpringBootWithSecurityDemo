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
import com.telemune.marketplace.rest.entity.ServiceChargeDetail;
import com.telemune.marketplace.rest.entity.embedded.PackIds;
import com.telemune.marketplace.rest.entity.embedded.PackTypeIds;
import com.telemune.marketplace.rest.entity.vo.PackDetail;
import com.telemune.marketplace.rest.entity.vo.PackPriority;
import com.telemune.marketplace.rest.entity.vo.PackVO;
import com.telemune.marketplace.rest.repository.DescServiceChargeDetailRepository;
import com.telemune.marketplace.rest.repository.PackRepository;
import com.telemune.marketplace.rest.repository.PackTypeRepository;
import com.telemune.marketplace.rest.service.IPackService;

@Service
public class PackServiceImpl implements IPackService {

	@Autowired
	PackRepository packRepository;

	@Autowired
	PackTypeRepository packTypeRepository;

	@Autowired
	DescServiceChargeDetailRepository descServiceChargeDetailRepository;

	private static final Logger logger = Logger.getLogger(PackServiceImpl.class);

	@Override
	public PackVO findByPackIdAndLanguageId(Integer id, String languageId) {

		logger.info("Inside findByPackIdAndLanguageId() method of PackServiceImpl class");

		Optional<Pack> packdb = packRepository.findByPackIds(new PackIds(id, languageId));

		logger.debug(packdb.get().toString());

		if (packdb.isPresent()) {

			PackVO packVO = ModelToVOAssmbler.convertToPackToPackVo(packdb.get());

			Optional<PackType> packdb1 = packTypeRepository
					.findByPackTypeIds(new PackTypeIds(packVO.getPackType(), "1"));
			if (packdb1.isPresent()) {
				packVO.setPackTypeName(packdb1.get().getPackTypeName());
			}

			Optional<ServiceChargeDetail> serviceChargeDetail = descServiceChargeDetailRepository
					.findByPackId(packVO.getPackId());

			if (serviceChargeDetail.isPresent()) {
				packVO.setProductCode(serviceChargeDetail.get().getProductCode());
				packVO.setServiceCharge(serviceChargeDetail.get().getServiceCharge());
				packVO.setStatus(serviceChargeDetail.get().getStatus());
				packVO.setValidityDays(serviceChargeDetail.get().getValidityDays());
				packVO.setValidityType(serviceChargeDetail.get().getValidityType());
				packVO.setVolume(serviceChargeDetail.get().getVolume());
				packVO.setVolumeType(serviceChargeDetail.get().getVolumeType());

			}
			logger.info("Exit findByPackIdAndLanguageId() method of PackServiceImpl class");
			return packVO;
		}
		logger.info("Exit findByPackIdAndLanguageId() method of PackServiceImpl class");
		return new PackVO();
	}

	@Override
	@Transactional
	public PackVO createPlan(PackVO packVO) {

		logger.info("Inside createPlan() method of PackServiceImpl class");
		System.out.println("inside create plan method "+packVO.toString());
		int newPackId = 1 + packRepository.maxPackId();

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		Pack pack = null;

		Pack packFinal = VOToModelAssmbler.convertToPackVOToPack(packVO);
		try {
			System.out.print("inside For loop of create plan");
			for (PackDetail pd : packVO.getPackDetails()) {

				PackIds packIds = new PackIds();

				packFinal.setPackName(pd.getPackName());
				packFinal.setDescription(pd.getDescripation());

				packIds.setLanguageId(String.valueOf(pd.getLanguageId()));
				packIds.setPackId(newPackId);
				packFinal.setPackIds(packIds);
				packFinal.setPriority(-99);
				packFinal.setSubPackType(4);
				packFinal.setCreateDate(date);

				pack = packRepository.save(packFinal);
			}

			ServiceChargeDetail serviceChargeDetail = new ServiceChargeDetail();
			serviceChargeDetail.setPackId(pack.getPackIds().getPackId());
			serviceChargeDetail.setProductCode(packVO.getProductCode());
			serviceChargeDetail.setServiceCharge(packVO.getServiceCharge());
			serviceChargeDetail.setStatus(packVO.getStatus());
			serviceChargeDetail.setValidityDays(packVO.getValidityDays());
			serviceChargeDetail.setValidityType(packVO.getValidityType());
			serviceChargeDetail.setVolume(packVO.getVolume());
			serviceChargeDetail.setVolumeType(packVO.getVolumeType());
			serviceChargeDetail.setCreateDate(date);
			descServiceChargeDetailRepository.save(serviceChargeDetail);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		logger.info("Exit createPlan() method of PackServiceImpl class");
		return ModelToVOAssmbler.convertToPackToPackVo(pack);

	}

	@Override
	@Transactional
	public PackVO updatePlan(PackVO packVO) {

		logger.info("Inside updatePlan() method of PackServiceImpl class");
		Pack pack = null;
		
		System.out.println("inside update plan method "+packVO.toString());

		try {
			for (PackDetail pd : packVO.getPackDetails()) {
				System.out.println("inside try and for loop of update  method ");
				//
				Optional<Pack> packdb = packRepository
						.findByPackIds(new PackIds(packVO.getPackId(), String.valueOf(pd.getLanguageId())));
				logger.debug(packdb.get().toString());
                
				if (packdb.isPresent()) {

					System.out.println("inside if statement update  method ");

					Pack packFinal = VOToModelAssmbler.convertToPackVOToPack(packVO, packdb.get());

					packFinal.setPackName(pd.getPackName());
					packFinal.setDescription(pd.getDescripation());

					pack = packRepository.save(packFinal);

					Optional<ServiceChargeDetail> serviceChargedb = descServiceChargeDetailRepository
							.findByPackId(packVO.getPackId());

					if (serviceChargedb.isPresent()) {
						ServiceChargeDetail serviceChargeDetail = serviceChargedb.get();
						serviceChargeDetail.setPackId(pack.getPackIds().getPackId());
						serviceChargeDetail.setProductCode(packVO.getProductCode());
						serviceChargeDetail.setServiceCharge(packVO.getServiceCharge());
						serviceChargeDetail.setStatus(packVO.getStatus());
						serviceChargeDetail.setValidityDays(packVO.getValidityDays());
						serviceChargeDetail.setValidityType(packVO.getValidityType());
						serviceChargeDetail.setVolume(packVO.getVolume());
						serviceChargeDetail.setVolumeType(packVO.getVolumeType());
						descServiceChargeDetailRepository.save(serviceChargeDetail);
					}

				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("outside of try and for loop of update  method "+pack.toString());

		logger.info("Exit createPlan() method of PackServiceImpl class");

		return ModelToVOAssmbler.convertToPackToPackVo(pack);
	}

	@Override
	public List<PackVO> findById(Integer id) {

		logger.info("Inside findById() method of PackServiceImpl class");
		List<PackVO> finalPackVO = new ArrayList<>();

		List<Pack> packdbList = packRepository.findByPackIdsPackId(id);

		logger.debug(packdbList.toString());

		for (Pack pk : packdbList) {
			PackVO packVO = ModelToVOAssmbler.convertToPackToPackVo(pk);
			Optional<PackType> packdb = packTypeRepository
					.findByPackTypeIds(new PackTypeIds(packVO.getPackType(), "1"));
			if (packdb.isPresent()) {
				packVO.setPackTypeName(packdb.get().getPackTypeName());
			}

			Optional<ServiceChargeDetail> serviceChargeDetail = descServiceChargeDetailRepository
					.findByPackId(packVO.getPackId());

			if (serviceChargeDetail.isPresent()) {
				packVO.setProductCode(serviceChargeDetail.get().getProductCode());
				packVO.setServiceCharge(serviceChargeDetail.get().getServiceCharge());
				packVO.setStatus(serviceChargeDetail.get().getStatus());
				packVO.setValidityDays(serviceChargeDetail.get().getValidityDays());
				packVO.setValidityType(serviceChargeDetail.get().getValidityType());
				packVO.setVolume(serviceChargeDetail.get().getVolume());
				packVO.setVolumeType(serviceChargeDetail.get().getVolumeType());
				finalPackVO.add(packVO);
			}
		}
		logger.info("Exit createPlan() method of PackServiceImpl class");
		return finalPackVO;
	}

	@Override
	public Pages findAllPlanWithPagination(Integer pageNo, Integer pageSize,String status,String packName)
	{

		logger.info("Inside findAllPlanWithPagination() method of PackServiceImpl class");
		  Page<Pack> pagedResult = null;
		  Pageable paging = PageRequest.of(pageNo, pageSize);
		try {
			if (status!=null && !status.isEmpty() )
			{
				System.out.println("here is the status we get "+status);
				pagedResult = packRepository.findBystatus(status, paging);
			}
			else if(packName!=null  && !packName.isEmpty())	
			{
				pagedResult = packRepository.findByPackName(packName, paging);
			}
			else{
				
			
				pagedResult = packRepository.findAll(paging);
			}
			
			logger.debug(pagedResult.toString());

			List<Object> finalPackVO = new ArrayList<>();
			if (pagedResult.hasContent()) {
				Pages pages = new Pages();
				pages.setTotalElements(pagedResult.getTotalElements());
				pages.setTotalPages(pagedResult.getTotalPages());
				List<Pack> packdbList = pagedResult.getContent();
				List<PackDetail> packDetaillst = new ArrayList<>();
				for (Pack pk : packdbList) {
					PackVO packVO = ModelToVOAssmbler.convertToPackToPackVo(pk);

					packVO.setPackDetails(packDetaillst);

					Optional<PackType> packdb = packTypeRepository
							.findByPackTypeIds(new PackTypeIds(packVO.getPackType(), "1"));
					if (packdb.isPresent()) {
						packVO.setPackTypeName(packdb.get().getPackTypeName());
					}

					Optional<ServiceChargeDetail> serviceChargeDetail = descServiceChargeDetailRepository
							.findByPackId(packVO.getPackId());

					if (serviceChargeDetail.isPresent()) {
						packVO.setProductCode(serviceChargeDetail.get().getProductCode());
						packVO.setServiceCharge(serviceChargeDetail.get().getServiceCharge());
						packVO.setStatus(serviceChargeDetail.get().getStatus());
						packVO.setValidityDays(serviceChargeDetail.get().getValidityDays());
						packVO.setValidityType(serviceChargeDetail.get().getValidityType());
						packVO.setVolume(serviceChargeDetail.get().getVolume());
						packVO.setVolumeType(serviceChargeDetail.get().getVolumeType());

					}

					finalPackVO.add(packVO);
				}
				pages.setContent(finalPackVO);
				logger.info("Exit findAllPlanWithPagination() method of PackServiceImpl class");

				return pages;

			}

			else {
				logger.info("Exit findAllPlanWithPagination() method of PackServiceImpl class");
				return new Pages();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Pages();
	}

	@Override
	@Transactional
	public boolean planDeleteById(Integer id) {

		logger.info("inside planDeleteById() method of PackServiceImpl class");

		List<Pack> packdbList = packRepository.findByPackIdsPackId(id);

		if (!packdbList.isEmpty()) {
			try {

				packRepository.deleteAllByPackIdsPackId(id);

				descServiceChargeDetailRepository.deleteAllByPackId(id);
			} catch (Exception exp) {
				exp.printStackTrace();

			}
			logger.info("Exit planDeleteById() method of PackServiceImpl class");
			return true;
		}
		logger.info("Exit planDeleteById() method of PackServiceImpl class");
		return false;
	}

	@Override
	public List<PackVO> findAllPlans() {

		logger.info("Inside findAllPlans() method of PackServiceImpl class");

		List<PackVO> finalPackVO = new ArrayList<>();
		List<Pack> packdbList = packRepository.findAll();

		for (Pack pk : packdbList) {
			PackVO packVO = ModelToVOAssmbler.convertToPackToPackVo(pk);

			Optional<PackType> packdb = packTypeRepository
					.findByPackTypeIds(new PackTypeIds(packVO.getPackType(), "1"));
			if (packdb.isPresent()) {
				packVO.setPackTypeName(packdb.get().getPackTypeName());
			}

			Optional<ServiceChargeDetail> serviceChargeDetail = descServiceChargeDetailRepository
					.findByPackId(packVO.getPackId());

			if (serviceChargeDetail.isPresent()) {
				packVO.setProductCode(serviceChargeDetail.get().getProductCode());
				packVO.setServiceCharge(serviceChargeDetail.get().getServiceCharge());
				packVO.setStatus(serviceChargeDetail.get().getStatus());
				packVO.setValidityDays(serviceChargeDetail.get().getValidityDays());
				packVO.setValidityType(serviceChargeDetail.get().getValidityType());
				packVO.setVolume(serviceChargeDetail.get().getVolume());
				packVO.setVolumeType(serviceChargeDetail.get().getVolumeType());

			}
			logger.info("Exit findAllPlans() method of PackServiceImpl class");
			finalPackVO.add(packVO);
		}
		logger.info("Exit findAllPlans() method of PackServiceImpl class");
		return finalPackVO;
	}

	@Override
	public List<Object> findAllPlanPriority(Integer packTypeId, Integer langId) {

		logger.info("Inside findAllPlanPriority() method of PackServiceImpl class");

		Optional<List<Pack>> pagedResult = packRepository.findByPackTypeAndPackIdsLanguageId(packTypeId,
				String.valueOf(langId));

		logger.debug(pagedResult.toString());

		List<Object> finalPackVO = new ArrayList<>();

		if (pagedResult.isPresent()) {
			List<Pack> packdbList = pagedResult.get();
			List<PackDetail> packDetaillst = new ArrayList<>();
			for (Pack pk : packdbList) {
				PackVO packVO = ModelToVOAssmbler.convertToPackToPackVo(pk);

				packVO.setPackDetails(packDetaillst);

				Optional<PackType> packdb = packTypeRepository.findByPackTypeIds(
						new PackTypeIds(packVO.getPackType(), String.valueOf(packVO.getLanguageId())));
				if (packdb.isPresent()) {
					packVO.setPackTypeName(packdb.get().getPackTypeName());
				}

				Optional<ServiceChargeDetail> serviceChargeDetail = descServiceChargeDetailRepository
						.findByPackId(packVO.getPackId());

				if (serviceChargeDetail.isPresent()) {
					packVO.setProductCode(serviceChargeDetail.get().getProductCode());
					packVO.setServiceCharge(serviceChargeDetail.get().getServiceCharge());
					packVO.setStatus(serviceChargeDetail.get().getStatus());
					packVO.setValidityDays(serviceChargeDetail.get().getValidityDays());
					packVO.setValidityType(serviceChargeDetail.get().getValidityType());
					packVO.setVolume(serviceChargeDetail.get().getVolume());
					packVO.setVolumeType(serviceChargeDetail.get().getVolumeType());

				}

				finalPackVO.add(packVO);
			}
			logger.info("Inside findAllPlanPriority() method of PackServiceImpl class");
			return finalPackVO;

		} else {
			logger.info("Inside findAllPlanPriority() method of PackServiceImpl class");
			return new ArrayList<Object>();
		}
	}

	@Override
	public boolean updatePlanPriority(PackPriority packPriority) {

		logger.info("Inside updatePlanPriority() method of PackServiceImpl class");

		try {
			if (packPriority.getPackLst() != null) {
				for (PackVO packVO : packPriority.getPackLst()) {
					List<Pack> packdbList = packRepository.findByPackIdsPackId(packVO.getPackId());
					logger.debug(packdbList);

					for (Pack pack : packdbList) {

						pack.setPriority(packVO.getPriority());
						packRepository.save(pack);

					}
				}
				logger.info("Exit updatePlanPriority() method of PackServiceImpl class");
				return true;

			} else
				logger.info("Exit updatePlanPriority() method of PackServiceImpl class");
			return false;

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		logger.info("Exit updatePlanPriority() method of PackServiceImpl class");
		return false;

	}
}
