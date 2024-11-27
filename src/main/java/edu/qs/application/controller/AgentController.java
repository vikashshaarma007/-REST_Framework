package edu.qs.application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import edu.qs.application.service.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
	 @Autowired
	    private AgentService agentService;

	 @GetMapping
	 public List<Agent> getAllAgents() {
	     return agentService.getAllAgents();
	 }

	    @PostMapping
	    public Agent createAgent(@RequestBody Agent agent) {
	        return agentService.createAgent(agent);
	    }

	    @PutMapping("/{id}")
	    public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
	        return agentService.updateAgent(id, agent);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAgent(@PathVariable Long id) {
	        agentService.deleteAgent(id);
	    }

}
