package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.entity.HttpLinks;
import com.telemune.marketplace.rest.entity.vo.HttpLinksVO;

public interface IHttpLinksService {
	
     public HttpLinksVO createHttpLinks(HttpLinksVO httpLinksVO);
     
     public HttpLinksVO updateHttpLinks(HttpLinksVO httpLinksVO);
     
     public List<HttpLinks> findAllHttpLinks();
     
     public HttpLinks findByHttpLinksId(Integer id);
     
     //public List<HttpLinksVO> findAllHttpLinksByRoleId(String id);

}
