package com.telemune.marketplace.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.JwtResponse;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.HttpLinks;
import com.telemune.marketplace.rest.entity.vo.RoleVO;
import com.telemune.marketplace.rest.entity.vo.UserVO;
import com.telemune.marketplace.rest.jwt.JwtProvider;
import com.telemune.marketplace.rest.service.IHttpLinksService;
import com.telemune.marketplace.rest.service.IRoleService;
import com.telemune.marketplace.rest.service.IUserService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 * @author manjeet
 * @version 4.0.0
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	IUserService userService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IHttpLinksService httpLinksService;
	
	private static final Logger logger = Logger.getLogger(AuthRestAPIs.class);

	

	/**
	 * 
	 * <b> This method use to login the users </b>
	 *
	 * @param userVO its object of UserVO class
	 * @return Response its return Response Type object
	 */
	@PostMapping("/signin")
	public Response authenticateUser(@Valid @RequestBody UserVO userVO) {

		try {

			logger.info("Inside authenticateUser method in AuthRestAPIs class and --- user input --- " + userVO.toString());
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userVO.getUsername(), userVO.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = jwtProvider.generateJwtToken(authentication);

			logger.debug(jwt);

			if (jwt != null) {

				logger.info("User Authenticate with user details ----" + userVO.toString());
				List<Object> userlst = new ArrayList<>();

				UserVO userVOdb = userService.findByUsername(userVO.getUsername());
				userlst.add(userVOdb);
				userlst.add(new JwtResponse(jwt));

				RoleVO roleVO = roleService.findById(userVOdb.getRoleId());
				userlst.add(roleVO);

				List<HttpLinks> httpLinks = httpLinksService.findAllHttpLinks();
				userlst.add(httpLinks);

				logger.info("login Details ---" + userlst.toString());
				
				logger.info("Exit authenticateUser method in AuthRestAPIs class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userlst, "Login suceessfully",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			}
			
			logger.info("User Authentication failed --User details-- " + userVO.toString());
			logger.info("Exit Authenticate user method in AuthRestAPIs class");
			
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					"failed login", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		} catch (Exception exp) {
			logger.error(" Exception ===>"+exp.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exp.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}
}
