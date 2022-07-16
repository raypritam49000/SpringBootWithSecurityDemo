package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.entity.vo.UserVO;
import com.telemune.marketplace.rest.exception.UserAlreadyExitException;

/**
 * @author manjeet
 *
 */
public interface IUserService {

	/**
	 * find all user by name
	 * 
	 * @param username
	 * @return UserVO UserVO object return
	 */
	UserVO findByUsername(String username);

	/**
	 * this method create the user
	 * 
	 * @param UserVO userVO
	 * @return UserVO UserVO object return
	 * @throws UserAlreadyExitException
	 */
	UserVO createUser(UserVO UserVO) throws UserAlreadyExitException;

	/**
	 * this method update the user
	 * 
	 * @param UserVO userVO
	 * @return UserVO UserVO object return
	 */
	UserVO userUpdate(UserVO UserVO);

	List<UserVO> findAllUser();

	boolean userDeleteByUsername(String username);
}
