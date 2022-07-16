package com.telemune.marketplace.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.assmbler.ModelToVOAssmbler;
import com.telemune.marketplace.rest.entity.TransferValidityConfig;
import com.telemune.marketplace.rest.entity.embedded.TransferValidityConfigIds;
import com.telemune.marketplace.rest.entity.vo.TransferValidityConfigVO;
import com.telemune.marketplace.rest.entity.vo.TransferValidityDetail;
import com.telemune.marketplace.rest.repository.TransferValidityConfigRepository;
import com.telemune.marketplace.rest.service.ITransferValidityConfigService;

@Service
public class TransferValidityConfigServiceImpl implements ITransferValidityConfigService {

	@Autowired
	TransferValidityConfigRepository transferValidityConfigRepository;

	@Override
	public TransferValidityConfigVO createTransferValidity(TransferValidityConfigVO transferValidityConfigVO) {

		transferValidityConfigRepository.deleteAll();

		try {
			TransferValidityConfig tvc = null;
			for (TransferValidityDetail tvcc : transferValidityConfigVO.getTransferValiditylst()) {

				TransferValidityConfig transferValidityConfig = new TransferValidityConfig();
				TransferValidityConfigIds transferValidityIds = new TransferValidityConfigIds();

				transferValidityIds.setMaxVolume(tvcc.getMaxVolume());
				transferValidityIds.setMinVolume(tvcc.getMinVolume());
				transferValidityIds.setType(6);
				transferValidityConfig.setTransferValidityConfigIds(transferValidityIds);
				transferValidityConfig.setValidityDays(tvcc.getValidityDays());

				tvc = transferValidityConfigRepository.save(transferValidityConfig);

			}
			return ModelToVOAssmbler.convertToTransferValidityToTransferValidityVo(tvc);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("ex   =  " + ex);

		}

		return new TransferValidityConfigVO();
	}

	@Override
	public List<TransferValidityConfigVO> findAllTarnsferValidity() {
		List<TransferValidityConfigVO> finalTvcVO = new ArrayList<>();
		List<TransferValidityConfig> packdbList = transferValidityConfigRepository.findAll();

		if (!packdbList.isEmpty()) {
			for (TransferValidityConfig tvc : packdbList) {
				TransferValidityConfigVO tvcVO = ModelToVOAssmbler.convertToTransferValidityToTransferValidityVo(tvc);
				finalTvcVO.add(tvcVO);
			}
		}
		return finalTvcVO;
	}

}
