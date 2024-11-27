package edu.qs.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.model.Campaign;
import edu.qs.application.model.CampaignResult;
import edu.qs.application.repository.CampaignResultRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CampaignResultService {
	
	 @Autowired
	    private CampaignResultRepository campaignResultRepository;

	    public CampaignResult createCampaignResult(CampaignResult campaignResult) {
	        campaignResult.setCreatedAt(LocalDateTime.now());
	        campaignResult.setUpdatedAt(LocalDateTime.now());
	        return campaignResultRepository.save(campaignResult);
	    }
	    
	    public List<CampaignResult> getAllCampaignsResult() {
		    return campaignResultRepository.findAll();
		    
		    
		}
	    
	    public CampaignResult getCampaignResultById(Long id) {
	        return campaignResultRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Campaign Result not found with ID: " + id));
	    }
	    
	    public CampaignResult updateCampaignResult(Long id, CampaignResult updatedResult) {
	        return campaignResultRepository.findById(id).map(result -> {
	            result.setName(updatedResult.getName());
	            result.setType(updatedResult.getType());
	            result.setPhone(updatedResult.getPhone());
	            result.setCost(updatedResult.getCost());
	            result.setOutcome(updatedResult.getOutcome());
	            result.setCallDuration(updatedResult.getCallDuration());
	            result.setRecordingUrl(updatedResult.getRecordingUrl());
	            result.setSummary(updatedResult.getSummary());
	            result.setTranscription(updatedResult.getTranscription());
	            result.setCampaign(updatedResult.getCampaign());
	            result.setUpdatedAt(LocalDateTime.now());
	            return campaignResultRepository.save(result);
	        }).orElseThrow(() -> new EntityNotFoundException("Campaign Result not found with ID: " + id));
	    }

	    public void deleteCampaignResult(Long id) {
	        campaignResultRepository.deleteById(id);
	    }

		
}
