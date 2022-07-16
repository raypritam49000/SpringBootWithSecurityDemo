package com.telemune.marketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.vo.UserVO;
import com.telemune.marketplace.rest.service.IUserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/user")
public class UserController {

	@Autowired
	IUserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	@SuppressWarnings("unused")
	@PostMapping()
	public Response createUser(@RequestBody UserVO userVO) {
		try {

			logger.info("inside createUser() method of UserController class");
			logger.info("user input ==> userVO--" + userVO.toString());
			if (null != userVO) {
				UserVO userVOdb = userService.createUser(userVO);

				logger.debug(userVOdb.toString());
				if (null != userVOdb && null != userVOdb.getUsername()) {
					logger.info("Exit createUser() method of UserController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"User created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				} else {
					logger.info("Exit createUser() method of UserController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Error while  creating the user", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}
			}
		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.getMessage(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
		logger.info("Exit findAllRole() method of UserController class");
		return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
				"Error while  creating the user", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}

	@PutMapping()
	public Response updateUser(@RequestBody UserVO userVO) {
		try {
			logger.info("Inside updateUser() method of UserController class");
			logger.info("user input ==> userVO--" + userVO.toString());
			if (null != userVO && null != userVO.getUsername()) {
				UserVO userVOdb = userService.userUpdate(userVO);
				logger.debug(userVOdb.toString());
				if (null != userVOdb && userVOdb.getUsername() != null) {
					logger.info("Exit updateUser() method of UserController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"Plan created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("Exit updateUser() method of UserController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Error while Updating the user", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}
			}
			return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					"object is null", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.getMessage(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@GetMapping("/all")
	public Response findAllUser() {

		try {
			logger.info("inside findAllUser() method of UserController class");
			List<UserVO> userVOlst = userService.findAllUser();
			logger.debug(userVOlst.toString());
			if (null != userVOlst && !userVOlst.isEmpty()) {
				logger.info(userVOlst);
				logger.info("exit findAllUser() method of UserController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info(userVOlst);
				logger.info("exit findAllUser() method of UserController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, userVOlst,
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.getMessage(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}
	}

	@GetMapping("/find/{username}")
	public Response findByUserId(@PathVariable(name = "username") String username) {

		logger.info("Inside findByUserId() method of findByUserId class");
		logger.info("user input ==> username--" + username);

		try {
			List<UserVO> userVOlst = new ArrayList<>();
			UserVO userVOdb = null;
			if (null != username) {
				userVOdb = userService.findByUsername(username);
				logger.debug(userVOdb.toString());
			}
			if (null != userVOdb && userVOdb.getUsername() != null) {
				userVOlst.add(userVOdb);
				logger.info("Exit findByUserId() method of findByUserId class");

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userVOlst, "user detailt",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				logger.info("Exit findByUserId() method of findByUserId class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, userVOlst,
						"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.getMessage(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}

	@DeleteMapping("/{username}")
	public Response deleteByUsername(@PathVariable(name = "username") String username) {

		logger.info("inside deleteByUsername() method of deleteByUsername class");
		logger.info("user input ==> username--" + username);

		try {

			if (null != username) {
				boolean isUserDeleted = userService.userDeleteByUsername(username);
				logger.debug("" + isUserDeleted);
				if (isUserDeleted) {
					logger.info("exit deleteByUsername() method of deleteByUsername class");
					return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
							"User deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				} else {
					logger.info("exit deleteByUsername() method of deleteByUsername class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "User is not deleted", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				logger.info("Exit deleteByUsername() method of deleteByUsername class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"User is not deleted", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}

}
