package edu.qs.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.qs.application.model.Agent;
import edu.qs.application.model.CampaignResult;
import edu.qs.application.service.CampaignResultService;

@RestController
@RequestMapping("/api/campaign-results")
public class CampaignResultController {
	@Autowired
    private CampaignResultService campaignResultService;

    @PostMapping
    public CampaignResult createCampaignResult(@RequestBody CampaignResult campaignResult) {
        return campaignResultService.createCampaignResult(campaignResult);
    }
    
     @GetMapping
	 public List<CampaignResult> getAllCampaignResults() {
	     return campaignResultService.getAllCampaignsResult();
	 }
     
  // Fetch a single campaign result by ID
     @GetMapping("/{id}")
     public CampaignResult getCampaignResultById(@PathVariable Long id) {
         return campaignResultService.getCampaignResultById(id);
     }
     
  // Update an existing campaign result
     @PutMapping("/{id}")
     public CampaignResult updateCampaignResult(@PathVariable Long id, @RequestBody CampaignResult campaignResult) {
         return campaignResultService.updateCampaignResult(id, campaignResult);
     }

     // Delete a campaign result by ID
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteCampaignResult(@PathVariable Long id) {
         campaignResultService.deleteCampaignResult(id);
         return ResponseEntity.ok("Campaign Result with ID " + id + " has been deleted.");
     }

}
