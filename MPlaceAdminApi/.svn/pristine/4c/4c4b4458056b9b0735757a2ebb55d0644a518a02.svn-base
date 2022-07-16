package com.telemune.marketplace.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telemune.marketplace.rest.entity.LbsTemplate;
import com.telemune.marketplace.rest.entity.embedded.LbsTemplateIds;

public interface LbsTemplateRepository extends JpaRepository<LbsTemplate, LbsTemplateIds> {

	Optional<LbsTemplate> findByLbsTemplateIds(LbsTemplateIds lbsTemplateIds);

	List<LbsTemplate> findByLbsTemplateIdsTemplateId(Integer id);
	
	@Query(value = "SELECT max(t.lbsTemplateIds.templateId) FROM LbsTemplate t")
	public int maxTemplateId();

	void deleteAllByLbsTemplateIdsTemplateId(Integer id);

	List<LbsTemplate> findByLbsTemplateIdsLanguageId(Integer id);

	Page<LbsTemplate> findByLbsTemplateIdsLanguageId(Integer lanid, Pageable paging);

	Page<LbsTemplate> findByTemplateMessage(String query, Pageable paging);

	Page<LbsTemplate> findByLbsTemplateIdsLanguageIdOrLbsTemplateIdsTemplateId(Integer valueOf, Pageable paging);

}
