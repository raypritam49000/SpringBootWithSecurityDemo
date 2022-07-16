package com.telemune.marketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.vo.TransferValidityConfigVO;
import com.telemune.marketplace.rest.service.ITransferValidityConfigService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/tranafer/validity")
public class TransferValidityConfigController {

	@Autowired
	ITransferValidityConfigService transferValidityConfig;

	private static final Logger logger = Logger.getLogger(TransferValidityConfigController.class);

	@GetMapping("/all")
	public Response findAllITransferValidityConfig() {

		logger.info("Inside findAllITransferValidityConfig() method of TransferValidityConfigController class");

		try {
			List<TransferValidityConfigVO> tvcVOlst = transferValidityConfig.findAllTarnsferValidity();
			logger.debug(tvcVOlst.toString());

			if (tvcVOlst != null && !tvcVOlst.isEmpty()) {
				logger.info("exit findAllITransferValidityConfig() method of TransferValidityConfigController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, tvcVOlst, "Pack List",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.getMessage(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}
		logger.info("exit findAllITransferValidityConfig() method of TransferValidityConfigController class");
		return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
				Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

	}

	@SuppressWarnings("unused")
	@PostMapping()
	public Response createTransferValidity(@RequestBody TransferValidityConfigVO transferValidityConfigVO) {
		try {

			logger.info("inside createTransferValidity() method of TransferValidityConfigController class");
			logger.info("user input ==> TransferValidityConfigVO--" + transferValidityConfigVO.toString());

			if (null != transferValidityConfigVO) {
				TransferValidityConfigVO tvcVOdb = transferValidityConfig
						.createTransferValidity(transferValidityConfigVO);

				logger.debug(tvcVOdb.toString());
				if (null != tvcVOdb && tvcVOdb.getMaxVolume() != null) {
					logger.info("Exit createTransferValidity() method of TransferValidityConfigController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"Transfer validity created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("Exit createTransferValidity() method of TransferValidityConfigController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Not found value", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}
			}
		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
		logger.info("Exit createTransferValidity() method of TransferValidityConfigController class");
		return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
				"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}

}
