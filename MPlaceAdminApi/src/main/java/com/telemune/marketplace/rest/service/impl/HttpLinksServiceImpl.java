package com.telemune.marketplace.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.entity.HttpLinks;
import com.telemune.marketplace.rest.entity.vo.HttpLinksVO;
import com.telemune.marketplace.rest.repository.HttpLinksRepository;
import com.telemune.marketplace.rest.service.IHttpLinksService;

@Service
public class HttpLinksServiceImpl implements IHttpLinksService {

	@Autowired
	HttpLinksRepository httpLinksRepository;
	
	private static final Logger logger = Logger.getLogger(HttpLinksServiceImpl.class);

	@Override
	public HttpLinksVO createHttpLinks(HttpLinksVO httpLinksVO) {
		
        HttpLinks httpLinks = new HttpLinks();
		
		//Optional.ofNullable(httpLinksVO.getLinkId()).ifPresent(httpLinks::setLinkId);
		Optional.ofNullable(httpLinksVO.getDescription()).ifPresent(httpLinks::setDescription);

		HttpLinks httpLinksdb = httpLinksRepository.save(httpLinks);

		//Optional.ofNullable(httpLinksdb.getLinkId()).ifPresent(httpLinksVO::setLinkId);
		Optional.ofNullable(httpLinksdb.getDescription()).ifPresent(httpLinksVO::setDescription);

		return httpLinksVO;

	}

	@Override
	public HttpLinksVO updateHttpLinks(HttpLinksVO httpLinksVO) {
         
		HttpLinks httpLinks = new HttpLinks();
		
		Optional.ofNullable(httpLinksVO.getLinkId()).ifPresent(httpLinks::setLinkId);
		Optional.ofNullable(httpLinksVO.getDescription()).ifPresent(httpLinks::setDescription);

		HttpLinks httpLinksdb = httpLinksRepository.save(httpLinks);

		Optional.ofNullable(httpLinksdb.getLinkId()).ifPresent(httpLinksVO::setLinkId);
		Optional.ofNullable(httpLinksdb.getDescription()).ifPresent(httpLinksVO::setDescription);
		
		return httpLinksVO;
	}

	@Override
	public List<HttpLinks> findAllHttpLinks() {
		
		logger.info("Inside findAllHttpsLinks() method of HttpsController class");
		
		List<HttpLinks>  httpLinksdb= httpLinksRepository.findAll();
		
		logger.info("Exit findAllHttpsLinks() method of HttpsController class");
		
		return httpLinksdb;
	}

	@Override
	public HttpLinks findByHttpLinksId(Integer id) {
		
		HttpLinks  httpLinks=httpLinksRepository.findByLinkId(id);
		
		return httpLinks;
	}

}
