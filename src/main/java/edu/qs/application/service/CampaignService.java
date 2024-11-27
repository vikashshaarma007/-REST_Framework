package edu.qs.application.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import edu.qs.application.model.Campaign;

import edu.qs.application.repository.CampaignRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CampaignService {
	
	@Autowired
    private CampaignRepository campaignRepository;

	public List<Campaign> getAllCampaigns() {
	    return campaignRepository.findAll();
	}

    public Campaign createCampaign(Campaign campaign) {
        campaign.setCreatedAt(LocalDateTime.now());
        campaign.setUpdatedAt(LocalDateTime.now());
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign updatedCampaign) {
        return campaignRepository.findById(id).map(campaign -> {
            campaign.setCampaignName(updatedCampaign.getCampaignName());
            campaign.setType(updatedCampaign.getType());
            campaign.setPhoneNumber(updatedCampaign.getPhoneNumber());
            campaign.setStatus(updatedCampaign.getStatus());
            campaign.setUpdatedAt(LocalDateTime.now());
            return campaignRepository.save(campaign);
        }).orElseThrow(() -> new EntityNotFoundException("Campaign not found"));
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
