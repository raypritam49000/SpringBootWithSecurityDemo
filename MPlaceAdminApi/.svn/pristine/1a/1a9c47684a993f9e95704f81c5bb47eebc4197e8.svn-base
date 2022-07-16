package com.telemune.marketplace.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.assmbler.ModelToVOAssmbler;
import com.telemune.marketplace.rest.assmbler.VOToModelAssmbler;
import com.telemune.marketplace.rest.controller.HttpsController;
import com.telemune.marketplace.rest.entity.MarketPlaceAdminUser;
import com.telemune.marketplace.rest.entity.MarketPlaceRoles;
import com.telemune.marketplace.rest.entity.vo.UserVO;
import com.telemune.marketplace.rest.exception.UserAlreadyExitException;
import com.telemune.marketplace.rest.repository.MarketPlaceAdminUserRepository;
import com.telemune.marketplace.rest.repository.MarketPlaceRolesRepository;
import com.telemune.marketplace.rest.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = Logger.getLogger(HttpsController.class);

	@Autowired
	MarketPlaceAdminUserRepository marketPlaceAdminUserRepository;

	@Autowired
	MarketPlaceRolesRepository marketPlaceRolesRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserVO findByUsername(String username) {
		
		logger.info("Inside findByUsername() method function of IUserServiceImpl class");

		Optional<MarketPlaceAdminUser> marketPlaceAdminUser = marketPlaceAdminUserRepository.findByUsername(username);

		if (marketPlaceAdminUser.isPresent()) {
			
			logger.info("Exit from findByUsername() method function of IUserServiceImpl class");

			return ModelToVOAssmbler.convertToUserToUserVo(marketPlaceAdminUser.get());
	
		}
		logger.info("Exit from findByUsername() method function of IUserServiceImpl class");
		
		return new UserVO();
	}

	@Override
	public UserVO createUser(UserVO userVO) throws UserAlreadyExitException {
		try {
			
			logger.info("Inside createUser() method function of IUserServiceImpl class");
			
			Optional<MarketPlaceAdminUser> marketPlaceAdminUser = marketPlaceAdminUserRepository
					.findByUsername(userVO.getUsername());

			if (marketPlaceAdminUser.isPresent()) {
				
				logger.info("user Already Exit with name==="+marketPlaceAdminUser.get().getUsername());

				throw new UserAlreadyExitException("Username Already Exit");
			}

			else {

				MarketPlaceAdminUser adminUser = VOToModelAssmbler.convertToUserVoToUser(userVO);

				adminUser.setPassword(passwordEncoder.encode(userVO.getPassword()));

				MarketPlaceRoles marketPlaceRoles = marketPlaceRolesRepository.findByRoleId(userVO.getRoleId());
				adminUser.setCreatedBy("NA");
				adminUser.setMarketPlaceRoles(marketPlaceRoles);
				adminUser.setFirstLogin("0");
				adminUser.setUserType(String.valueOf(userVO.getRoleId()));

				MarketPlaceAdminUser adminUserdb = marketPlaceAdminUserRepository.save(adminUser);

				logger.info("Exit from createUser() method function of IUserServiceImpl class");
				
				return ModelToVOAssmbler.convertToUserToUserVo(adminUserdb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Exit from createUser() method function of IUserServiceImpl class");
		return new UserVO();

	}

	@Override
	@Transactional
	public UserVO userUpdate(UserVO userVO) {
		
		logger.info("Inside userUpdate() method function of IUserServiceImpl class");

		Optional<MarketPlaceAdminUser> marketPlaceAdminUser = marketPlaceAdminUserRepository
				.findByUsername(userVO.getUsername());

		if (marketPlaceAdminUser.isPresent()) {

			MarketPlaceAdminUser adminUser = VOToModelAssmbler.convertToUserVoToUser(userVO,
					marketPlaceAdminUser.get());

			adminUser.setPassword(passwordEncoder.encode(userVO.getPassword()));

			MarketPlaceRoles marketPlaceRoles = marketPlaceRolesRepository.findByRoleId(userVO.getRoleId());

			adminUser.setMarketPlaceRoles(marketPlaceRoles);

			MarketPlaceAdminUser adminUserdb = marketPlaceAdminUserRepository.save(adminUser);

			logger.info("Exit from userUpdate() method function of IUserServiceImpl class");
			
			return ModelToVOAssmbler.convertToUserToUserVo(adminUserdb);
		}
		else
			logger.info("Exit from userUpdate() method function of IUserServiceImpl class");
			return new UserVO();
	}

	@Override
	public List<UserVO> findAllUser() {

		logger.info("Inside findAllUser() method function of IUserServiceImpl class");
		List<UserVO> finalUserVO = new ArrayList<>();
		List<MarketPlaceAdminUser> userdbList = marketPlaceAdminUserRepository.findAll();

		for (MarketPlaceAdminUser mpAdminUser : userdbList) {
			UserVO userVO = ModelToVOAssmbler.convertToUserToUserVo(mpAdminUser);
			finalUserVO.add(userVO);
		}
		logger.info("Exit from  findAllUser() method function of IUserServiceImpl class");
		return finalUserVO;
	}

	@Override
	@Transactional
	public boolean userDeleteByUsername(String username) {
		// TODO Auto-generated method stub

		logger.info("Inside userDeleteByUsername() method function of IUserServiceImpl class");
		
		Optional<MarketPlaceAdminUser> marketPlaceAdminUser = marketPlaceAdminUserRepository.findByUsername(username);
		if (marketPlaceAdminUser.isPresent()) {

			{
				logger.info("Inside userDeleteByUsername() method function of IUserServiceImpl class");
				marketPlaceAdminUserRepository.deleteByUsername(username);
				return true;
			}

		}
		logger.info("Inside userDeleteByUsername() method function of IUserServiceImpl class");
		return false;

	}
}
