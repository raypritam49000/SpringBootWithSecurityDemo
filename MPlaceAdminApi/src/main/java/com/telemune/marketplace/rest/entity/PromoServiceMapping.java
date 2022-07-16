package com.telemune.marketplace.rest.entity;
/**
 * @author mayank
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.telemune.marketplace.rest.entity.embedded.PromoService;


@Entity
@Table(name = "promo_service_mapping ")
public class PromoServiceMapping implements Serializable {

private static final long serialVersionUID = 1L;

 @EmbeddedId
 private PromoService promoService;

  @Column(name = "SCOPE", nullable = false)
  private String scope;
  

public PromoService getPromoService() {
	return promoService;
}

public void setPromoService(PromoService promoService) {
	this.promoService = promoService;
}

public String getScope() {
	return scope;
}

public void setScope(String scope) {
	this.scope = scope;
}



@Override
public String toString() {
	return "PromoServiceMapping [promoService=" + promoService + ", scope=" + scope +  "]";
}





}
