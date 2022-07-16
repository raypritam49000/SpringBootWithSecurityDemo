package com.telemune.marketplace.rest.assmbler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.telemune.marketplace.rest.entity.LbsTemplate;
import com.telemune.marketplace.rest.entity.MarketPlaceAdminUser;
import com.telemune.marketplace.rest.entity.Pack;
import com.telemune.marketplace.rest.entity.PackType;
import com.telemune.marketplace.rest.entity.PromoPack;
import com.telemune.marketplace.rest.entity.PromoServiceMapping;
import com.telemune.marketplace.rest.entity.TransferValidityConfig;
import com.telemune.marketplace.rest.entity.WhiteBlackList;
import com.telemune.marketplace.rest.entity.vo.LbsTemplateVO;
import com.telemune.marketplace.rest.entity.vo.PackTypeVO;
import com.telemune.marketplace.rest.entity.vo.PackVO;
import com.telemune.marketplace.rest.entity.vo.PromoPackVO;
import com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO;
import com.telemune.marketplace.rest.entity.vo.TransferValidityConfigVO;
import com.telemune.marketplace.rest.entity.vo.UserVO;
import com.telemune.marketplace.rest.entity.vo.WhiteBlackVO;

@Component
public class ModelToVOAssmbler {

	public static PackVO convertToPackToPackVo(Pack pack) {

		PackVO packVO = new PackVO();
      System.out.print("Inside te modelToVoassembler class"+pack.toString());
		Optional.ofNullable(pack.getPackIds().getPackId()).ifPresent(id -> {
			packVO.setPackId(id);
		});

		Optional.ofNullable(pack.getPackName()).ifPresent(packVO::setPackName);
		Optional.ofNullable(pack.getDescription()).ifPresent(packVO::setDescripation);
		Optional.ofNullable(Integer.valueOf(pack.getPackIds().getLanguageId())).ifPresent(packVO::setLanguageId);
		Optional.ofNullable(pack.getAmountRequired()).ifPresent(packVO::setAmountRequired);
		Optional.ofNullable(pack.getCreateDate().toString()).ifPresent(packVO::setCreateDate);
		Optional.ofNullable(pack.getEndDate().toString()).ifPresent(packVO::setEndDate);
		Optional.ofNullable(pack.getIsRenewEnable()).ifPresent(packVO::setIsRenewEnable);
		Optional.ofNullable(pack.getOther()).ifPresent(packVO::setOther);
		Optional.ofNullable(pack.getPriority()).ifPresent(packVO::setPriority);
		Optional.ofNullable(pack.getPromptFile()).ifPresent(packVO::setPromptFile);
		Optional.ofNullable(pack.getReminderTempId()).ifPresent(packVO::setReminderTempId);
		Optional.ofNullable(pack.getSpecialPackType()).ifPresent(packVO::setSpecialPackType);
		Optional.ofNullable(pack.getStartDate().toString()).ifPresent(packVO::setStartDate);
		Optional.ofNullable(pack.getStatus()).ifPresent(packVO::setStatus);
		Optional.ofNullable(pack.getSubPackType()).ifPresent(packVO::setSubPackType);
		Optional.ofNullable(pack.getSubType()).ifPresent(packVO::setSubType);
		Optional.ofNullable(pack.getViewEnable()).ifPresent(packVO::setViewEnable);
		Optional.ofNullable(pack.getPackType()).ifPresent(packVO::setPackType);
		
		
		return packVO;
	}

	public static PackTypeVO convertToPackTypeToPackTypeVo(PackType packType) {

		PackTypeVO packTypeVO = new PackTypeVO();

		Optional.ofNullable(packType.getPackTypeIds().getPackTypeId()).ifPresent(id -> {
			packTypeVO.setPackType(id);
		});
		Optional.ofNullable(packType.getDescription()).ifPresent(packTypeVO::setDescription);
		Optional.ofNullable(packType.getPackTypeIds().getLanguageId()).ifPresent(packTypeVO::setLanguageId);
		Optional.ofNullable(packType.getPackTypeName()).ifPresent(packTypeVO::setPackTypeName);
		Optional.ofNullable(packType.getPackTypePrompt()).ifPresent(packTypeVO::setPackTypePrompt);
		Optional.ofNullable(packType.getParallelPackEnable()).ifPresent(packTypeVO::setParallelPackEnable);
		Optional.ofNullable(packType.getParentPackType()).ifPresent(packTypeVO::setParentPackType);
		Optional.ofNullable(packType.getPriority()).ifPresent(packTypeVO::setPriority);
		Optional.ofNullable(packType.getSTATUS()).ifPresent(packTypeVO::setStatus);
		Optional.ofNullable(packType.getSuperPackType()).ifPresent(packTypeVO::setSuperPackType);

		return packTypeVO;
	}

	public static UserVO convertToUserToUserVo(MarketPlaceAdminUser userAdmin) {

		UserVO userVO = new UserVO();

	//	Optional.ofNullable(userAdmin.getCreatedBy()).ifPresent(id -> {
		//	userVO.setCreatedBy(id);
		//});
		Optional.ofNullable(userAdmin.getEmail()).ifPresent(userVO::setEmail);
		Optional.ofNullable(userAdmin.getFirstLogin()).ifPresent(userVO::setFirstLogin);
		Optional.ofNullable(userAdmin.getMobileNumber()).ifPresent(userVO::setMobileNumber);
		Optional.ofNullable(userAdmin.getPassword()).ifPresent(userVO::setPassword);
		Optional.ofNullable(userAdmin.getUsername()).ifPresent(userVO::setUsername);
		Optional.ofNullable(userAdmin.getUserType()).ifPresent(userVO::setUserType);
		Optional.ofNullable(userAdmin.getMarketPlaceRoles().getRoleId()).ifPresent(userVO::setRoleId);
		Optional.ofNullable(userAdmin.getMarketPlaceRoles().getDescription()).ifPresent(userVO::setDescription);
		Optional.ofNullable(userAdmin.getMarketPlaceRoles().getRoleName()).ifPresent(userVO::setRoleName);

		return userVO;
	}

	public static LbsTemplateVO convertToLbsTemplateToLbsTemplateVo(LbsTemplate lbsTemplate) {

		LbsTemplateVO tempVO = new LbsTemplateVO();

		Optional.ofNullable(lbsTemplate.getLbsTemplateIds().getTemplateId()).ifPresent(tempVO::setTemplateId);
		Optional.ofNullable(lbsTemplate.getLbsTemplateIds().getLanguageId()).ifPresent(tempVO::setLanguageId);
		Optional.ofNullable(lbsTemplate.getTemplateType()).ifPresent(tempVO::setTemplateType);
		Optional.ofNullable(lbsTemplate.getTemplateName()).ifPresent(tempVO::setTemplateName);
		Optional.ofNullable(lbsTemplate.getTemplateDescription()).ifPresent(tempVO::setTemplateDescription);
		Optional.ofNullable(lbsTemplate.getTemplateMessage()).ifPresent(tempVO::setTemplateMessage);

		return tempVO;
	}

	/**
	 * @param tvc
	 * @return
	 */
	public static TransferValidityConfigVO convertToTransferValidityToTransferValidityVo(TransferValidityConfig tvc) {
		TransferValidityConfigVO transferValidityConfigVO = new TransferValidityConfigVO();

		Optional.ofNullable(tvc.getTransferValidityConfigIds().getMaxVolume())
				.ifPresent(transferValidityConfigVO::setMaxVolume);
		Optional.ofNullable(tvc.getTransferValidityConfigIds().getMinVolume())
				.ifPresent(transferValidityConfigVO::setMinVolume);
		Optional.ofNullable(tvc.getTransferValidityConfigIds().getType()).ifPresent(transferValidityConfigVO::setType);
		Optional.ofNullable(tvc.getCreateDate()).ifPresent(transferValidityConfigVO::setCreateDate);
		Optional.ofNullable(tvc.getValidityDays()).ifPresent(transferValidityConfigVO::setValidityDays);

		return transferValidityConfigVO;
	}

	public static PromoPackVO convertToPromoPackToPromoPackVo(PromoPack promoPack) {
		// TODO Auto-generated method stub
		
		
		PromoPackVO promoPackVO = new PromoPackVO();
		
		System.out.print("Inside te modelToVoassembler class"+promoPack.toString());
		
		Optional.ofNullable(promoPack.getCreateDate().toString()).ifPresent(promoPackVO::setCreateDate);
		Optional.ofNullable(promoPack.getPackType()).ifPresent(promoPackVO::setPackType);
		Optional.ofNullable(promoPack.getStatus()).ifPresent(promoPackVO::setStatus);
		Optional.ofNullable(promoPack.getPromoPackIds().getPackId()).ifPresent(promoPackVO::setPackId);
		Optional.ofNullable(promoPack.getOther()).ifPresent(promoPackVO::setOther);

		Optional.ofNullable(promoPack.getProductCode()).ifPresent(promoPackVO::setProductCode);
		Optional.ofNullable(promoPack.getSubType()).ifPresent(promoPackVO::setSubType);

		Optional.ofNullable(promoPack.getPromoPackIds().getLanguageId()).ifPresent(promoPackVO::setLanguageId);
		
		return promoPackVO;
	}

	public static WhiteBlackVO convertToWhiteBlackToWhiteBlackVo(WhiteBlackList wbl) {
		// TODO Auto-generated method stub
     WhiteBlackVO whiteBlackVO = new WhiteBlackVO();
		
		System.out.print("Inside te modelToVoassembler class"+wbl.toString());
		
		Optional.ofNullable(wbl.getCreateDate().toString()).ifPresent(whiteBlackVO::setCreateDate);
		Optional.ofNullable(wbl.getType()).ifPresent(whiteBlackVO::setType);
		
		
		Optional.ofNullable(wbl.getWhiteBlack().getMsisdn()).ifPresent(whiteBlackVO::setMsisdn);
	

   return whiteBlackVO;
	}

	public static PromoServiceMapVO convertToPromoServiceMapToPromoServiceMapVo(
			PromoServiceMapping promoServiceMapping) {
		// TODO Auto-generated method stub
		 PromoServiceMapVO promoServiceMapVO = new PromoServiceMapVO();
		 Optional.ofNullable(promoServiceMapping.getScope()).ifPresent(promoServiceMapVO::setScope);
		 Optional.ofNullable(promoServiceMapping.getPromoService().getMsisdn()).ifPresent(promoServiceMapVO::setMsisdn);
		 return promoServiceMapVO;
	}


	
}
