package com.telemune.marketplace.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.entity.HttpLinks;
import com.telemune.marketplace.rest.entity.MarketPlaceRoles;
import com.telemune.marketplace.rest.entity.vo.HttpLinksVO;
import com.telemune.marketplace.rest.entity.vo.RoleVO;
import com.telemune.marketplace.rest.repository.HttpLinksRepository;
import com.telemune.marketplace.rest.repository.MarketPlaceRolesRepository;
import com.telemune.marketplace.rest.service.IReportService;
import com.telemune.marketplace.rest.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	private static final Logger logger = Logger.getLogger(IReportService.class);

	@Autowired
	MarketPlaceRolesRepository marketPlaceRolesRepository;

	@Autowired
	HttpLinksRepository httpLinksRepository;

	@Override
	public RoleVO createRole(RoleVO roleVO) {

		logger.info("Inside createRole() method of RoleServiceImpl class");

		try {
			int newRoleId = 1 + marketPlaceRolesRepository.maxRoleId();

			MarketPlaceRoles marketPlaceRoles = new MarketPlaceRoles();

			Optional.ofNullable(roleVO.getDescription()).ifPresent(marketPlaceRoles::setDescription);
			Optional.ofNullable(roleVO.getRoleName()).ifPresent(marketPlaceRoles::setRoleName);
			marketPlaceRoles.setRoleId(newRoleId);

			List<HttpLinks> httplst = new ArrayList<>();

			for (HttpLinksVO hl : roleVO.getHttpLinkslst()) {
				HttpLinks httpdb = httpLinksRepository.findByLinkId(hl.getLinkId());
				httplst.add(httpdb);
			}
			marketPlaceRoles.setHttpLinks(httplst);
			MarketPlaceRoles marketPlaceRolesdb = marketPlaceRolesRepository.save(marketPlaceRoles);

			logger.debug(marketPlaceRolesdb.toString());

			if (marketPlaceRolesdb != null) {
				Optional.ofNullable(marketPlaceRolesdb.getDescription()).ifPresent(roleVO::setDescription);
				Optional.ofNullable(marketPlaceRolesdb.getRoleName()).ifPresent(roleVO::setRoleName);
				roleVO.setRoleId(marketPlaceRolesdb.getRoleId());
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}

		logger.info("Exit createRole() method of RoleServiceImpl class");
		return roleVO;
	}

	@Override
	@Transactional
	public RoleVO updateRole(RoleVO roleVO) {

		logger.info("Inside updateRole() method of RoleServiceImpl class");

		try {
			MarketPlaceRoles marketPlaceRoles = marketPlaceRolesRepository.findByRoleId(roleVO.getRoleId());

			if (marketPlaceRoles != null) {

				Optional.ofNullable(roleVO.getDescription()).ifPresent(marketPlaceRoles::setDescription);
				Optional.ofNullable(roleVO.getRoleName()).ifPresent(marketPlaceRoles::setRoleName);

				List<HttpLinks> httplst = new ArrayList<>();
				for (HttpLinksVO hl : roleVO.getHttpLinkslst()) {
					HttpLinks httpdb = httpLinksRepository.findByLinkId(hl.getLinkId());
					httplst.add(httpdb);
				}
				marketPlaceRoles.setHttpLinks(httplst);
				MarketPlaceRoles marketPlaceRolesdb = marketPlaceRolesRepository.save(marketPlaceRoles);

				logger.debug(marketPlaceRolesdb.toString());

				if (marketPlaceRolesdb != null) {
					Optional.ofNullable(marketPlaceRolesdb.getDescription()).ifPresent(roleVO::setDescription);
					Optional.ofNullable(marketPlaceRolesdb.getRoleName()).ifPresent(roleVO::setRoleName);
					roleVO.setRoleId(marketPlaceRolesdb.getRoleId());
				}
				logger.info("Exit updateRole() method of RoleServiceImpl class");
				return roleVO;
			}

			else
				logger.info("Exit updateRole() method of RoleServiceImpl class");
			return new RoleVO();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		logger.info("Exit updateRole() method of RoleServiceImpl class");
		return new RoleVO();

	}

	@Override
	public List<RoleVO> findAllRole() {
		// TODO Auto-generated method stub

		logger.info("Inside findAllRole() method of RoleServiceImpl class");

		List<RoleVO> roleVOlst = new ArrayList<>();

		List<MarketPlaceRoles> marketPlaceRoleslst = marketPlaceRolesRepository.findAll();

		for (MarketPlaceRoles mpr : marketPlaceRoleslst) {
			RoleVO role = new RoleVO();

			role.setRoleId(mpr.getRoleId());
			role.setRoleName(mpr.getRoleName());
			role.setDescription(mpr.getDescription());
			roleVOlst.add(role);

		}
		logger.info("Exit findAllRole() method of RoleServiceImpl class");
		return roleVOlst;
	}

	@Override
	public RoleVO findById(Integer id) {
		// TODO Auto-generated method stub
		logger.info("Inside findById() method of RoleServiceImpl class");

		MarketPlaceRoles marketPlaceRoles = marketPlaceRolesRepository.findByRoleId(id);

		logger.debug(marketPlaceRoles.toString());

		RoleVO roleVO = new RoleVO();

		if (marketPlaceRoles != null) {

			Optional.ofNullable(marketPlaceRoles.getRoleId()).ifPresent(roleVO::setRoleId);
			Optional.ofNullable(marketPlaceRoles.getDescription()).ifPresent(roleVO::setDescription);
			Optional.ofNullable(marketPlaceRoles.getRoleName()).ifPresent(roleVO::setRoleName);

			List<HttpLinksVO> httplst = new ArrayList<>();

			for (HttpLinks httpLinks : marketPlaceRoles.getHttpLinks()) {
				HttpLinksVO httpLinksVO = new HttpLinksVO();
				httpLinksVO.setDescription(httpLinks.getDescription());
				httpLinksVO.setLinkId(httpLinks.getLinkId());
				httplst.add(httpLinksVO);
			}
			logger.info("Exit findById() method of RoleServiceImpl class");
			roleVO.setHttpLinkslst(httplst);

		}
		return roleVO;
	}

	@Override
	@Transactional
	public boolean roleDeleteById(Integer roleId) {
		// TODO Auto-generated method stub

		MarketPlaceRoles marketPlaceRoles = marketPlaceRolesRepository.findByRoleId(roleId);

		logger.info("Inside roleDeleteById() method of RoleServiceImpl class");

		logger.debug(marketPlaceRoles.toString());

		try {
			if (marketPlaceRoles != null) {
				marketPlaceRolesRepository.deleteByRoleId(roleId);
				logger.info("Exit roleDeleteById() method of RoleServiceImpl class");
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Exit roleDeleteById() method of RoleServiceImpl class");
		return false;

	}

}
