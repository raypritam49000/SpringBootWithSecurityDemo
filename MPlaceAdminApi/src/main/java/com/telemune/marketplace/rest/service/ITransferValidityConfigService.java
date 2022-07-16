package com.telemune.marketplace.rest.service;

import java.util.List;

import com.telemune.marketplace.rest.entity.vo.TransferValidityConfigVO;

/**
 * @author manjeet
 *
 */
public interface ITransferValidityConfigService {

	/**
	 * @param transferValidityConfigVO
	 * @return
	 */
	public TransferValidityConfigVO createTransferValidity(TransferValidityConfigVO transferValidityConfigVO);

	/**
	 * @return
	 */
	public List<TransferValidityConfigVO> findAllTarnsferValidity();

}
