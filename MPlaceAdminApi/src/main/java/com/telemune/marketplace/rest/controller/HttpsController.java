package com.telemune.marketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.HttpLinks;
import com.telemune.marketplace.rest.service.IHttpLinksService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/https")
public class HttpsController {

	@Autowired
	IHttpLinksService httpLinksService;

	private static final Logger logger = Logger.getLogger(HttpsController.class);

	@SuppressWarnings("unused")
	@GetMapping("/all")
	public Response findAllHttpsLinks() {

		try {

			logger.info("inside findAllHttpsLinks() method of HttpsController class");
			List<HttpLinks> httpLinksVOlst;
			httpLinksVOlst = httpLinksService.findAllHttpLinks();
			logger.debug(httpLinksVOlst.toString());
			if (null != httpLinksVOlst) {
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, httpLinksVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("httpLinksVOlst ==>" + httpLinksVOlst.toString());
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

}
