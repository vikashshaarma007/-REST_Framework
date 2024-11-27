package edu.qs.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.qs.application.model.CampaignResult;

@Repository
public interface CampaignResultRepository extends JpaRepository<CampaignResult, Long> {

}
