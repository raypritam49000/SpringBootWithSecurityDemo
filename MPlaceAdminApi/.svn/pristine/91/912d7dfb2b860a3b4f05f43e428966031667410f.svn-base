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
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.LbsTemplate;
import com.telemune.marketplace.rest.entity.embedded.LbsTemplateIds;
import com.telemune.marketplace.rest.entity.vo.LbsTemplateVO;
import com.telemune.marketplace.rest.entity.vo.SmsTemplateDetail;
import com.telemune.marketplace.rest.repository.LbsTemplateRepository;
import com.telemune.marketplace.rest.service.ILbsTemplateService;

@Service
public class LbsTemplatelmpl implements ILbsTemplateService {

	@Autowired
	LbsTemplateRepository lbsTemplateRepository;

	private static final Logger logger = Logger.getLogger(LbsTemplatelmpl.class);

	@Override
	public LbsTemplateVO findByTemplateIdAndLanguageId(Integer id, Integer languageId) {
		
		logger.info("Inside findByTemplateIdAndLanguageId() method of LbsTemplatelmpl class");
		Optional<LbsTemplate> tempdb = lbsTemplateRepository.findByLbsTemplateIds(new LbsTemplateIds(id, languageId));
		logger.debug(tempdb);
		if (tempdb.isPresent()) {
			return ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(tempdb.get());
		}
		logger.info("Exit findByTemplateIdAndLanguageId() method of LbsTemplatelmpl class");
		return new LbsTemplateVO();
	}

	@Override
	public List<LbsTemplateVO> findByTemplateId(Integer id) {
		List<LbsTemplate> tempdblst = lbsTemplateRepository.findByLbsTemplateIdsTemplateId(id);

		logger.info("Inside findByTemplateId() method of LbsTemplatelmpl class");
		if (tempdblst != null) {

			List<LbsTemplateVO> ltlst = new ArrayList<>();

			for (LbsTemplate lt : tempdblst) {

				ltlst.add(ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(lt));
			}
			logger.debug(tempdblst.toString());
			logger.info("Exit findByTemplateId() method of LbsTemplatelmpl class");
			return ltlst;
		}
		return new ArrayList<>();
	}

	@Override
	public Pages findAllTmplateWithPagination(Integer pageNo, Integer pageSize, String lanid, String query) {
		// TODO Auto-generated method stub

		Page<LbsTemplate> pagedResult = null;
		Pageable paging = PageRequest.of(pageNo, pageSize);

		logger.info("Inside findAllTmplateWithPagination() method of ILbsTemplatelmpl class");

		if (lanid != null) {

			pagedResult = lbsTemplateRepository.findByLbsTemplateIdsLanguageId(Integer.valueOf(lanid), paging);
		} else if (query != null) {

			if (query.matches("[0-9]+") && query.length() > 0) {
				pagedResult = lbsTemplateRepository
						.findByLbsTemplateIdsLanguageIdOrLbsTemplateIdsTemplateId(Integer.valueOf(query), paging);
			} else
				pagedResult = lbsTemplateRepository.findByTemplateMessage(query, paging);
		}

		else {
			pagedResult = lbsTemplateRepository.findAll(paging);
		}

		List<Object> lbsTempVOlst = new ArrayList<>();
		
		logger.debug(pagedResult);

		if (pagedResult.hasContent()) {
			Pages pages = new Pages();
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());

			List<LbsTemplate> lbsdbList = pagedResult.getContent();
			for (LbsTemplate lbs : lbsdbList) {
				LbsTemplateVO lbsVO = ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(lbs);
				lbsTempVOlst.add(lbsVO);
			}
			pages.setContent(lbsTempVOlst);
			logger.info("Exit findAllTmplateWithPagination() method of LbsTemplatelmpl class");
			return pages;

		} else {
			logger.info("Exit findAllTmplateWithPagination() method of LbsTemplatelmpl class");
			return new Pages();
		}
		
	}

	@Override
	@Transactional
	public boolean templateDeleteById(Integer id) {

		logger.info("Inside templateDeleteById() method of ILbsTemplatelmpl class");

		List<LbsTemplate> tempdblst = lbsTemplateRepository.findByLbsTemplateIdsTemplateId(id);
		logger.debug(tempdblst);
		if (tempdblst != null && !tempdblst.isEmpty()) {
			lbsTemplateRepository.deleteAllByLbsTemplateIdsTemplateId(id);
			logger.info("Exit templateDeleteById() method of LbsTemplatelmpl class");
			return true;
		}
		logger.info("Exit templateDeleteById() method of LbsTemplatelmpl class");
		return false;
	}

	@Override
	public List<LbsTemplateVO> findByLanguageId(Integer id) {

		logger.info("Inside findByLanguageId() method of LbsTemplatelmpl class");

		List<LbsTemplate> tempdblst = lbsTemplateRepository.findByLbsTemplateIdsLanguageId(id);
       
		logger.debug(tempdblst.toString());
		
		List<LbsTemplateVO> ltlst = new ArrayList<>();
		for (LbsTemplate lt : tempdblst) {
			ltlst.add(ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(lt));
		}
		logger.info("Exit findByLanguageId() method of LbsTemplatelmpl class");
		return ltlst;

	}

	@Override
	public List<LbsTemplateVO> findAllTemplate() {

		logger.info("Inside findAllTemplate() method of LbsTemplatelmpl class");

		List<LbsTemplate> tempdblst = lbsTemplateRepository.findAll();
		
		logger.debug(tempdblst);

		if (tempdblst != null) {

			List<LbsTemplateVO> ltlst = new ArrayList<>();

			for (LbsTemplate lt : tempdblst) {

				ltlst.add(ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(lt));
			}
			logger.info("Exit findAllTemplate() method of LbsTemplatelmpl class");
			return ltlst;
		}
		logger.info("Exit findAllTemplate() method of LbsTemplatelmpl class");
		return new ArrayList<>();
	}

	@Override
	public LbsTemplateVO updateTemplate(LbsTemplateVO lbsTemplateVO) {

		logger.info("Inside updateTemplate() method of ILbsTemplatelmpl class");

		LbsTemplate lbsTemplate = null;
		try {
			for (SmsTemplateDetail std : lbsTemplateVO.getSmsTemplateDetaillst()) {
				Optional<LbsTemplate> lbsTempdb = lbsTemplateRepository
						.findByLbsTemplateIds(new LbsTemplateIds(std.getTemplateId(), std.getLanguageId()));

				if (lbsTempdb.isPresent()) {

					lbsTempdb.get().setTemplateMessage(std.getTemplateMessage());

					lbsTemplate = lbsTemplateRepository.save(lbsTempdb.get());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.debug(lbsTemplate);

		logger.info("Exit updateTemplate() method of LbsTemplatelmpl class");

		return ModelToVOAssmbler.convertToLbsTemplateToLbsTemplateVo(lbsTemplate);
	}

}
