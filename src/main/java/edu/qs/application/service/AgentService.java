package edu.qs.application.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.qs.application.model.Agent;
import edu.qs.application.repository.AgentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgentService {
	@Autowired
    private AgentRepository agentRepository;

	public List<Agent> getAllAgents() {
	    return agentRepository.findAll();
	}

    public Agent createAgent(Agent agent) {
        agent.setUpdated(LocalDateTime.now());
        return agentRepository.save(agent);
    }

    public Agent updateAgent(Long id, Agent updatedAgent) {
        return agentRepository.findById(id).map(agent -> {
            agent.setAgentName(updatedAgent.getAgentName());
            agent.setLanguage(updatedAgent.getLanguage());
            agent.setVoiceId(updatedAgent.getVoiceId());
            agent.setUpdated(LocalDateTime.now());
            return agentRepository.save(agent);
        }).orElseThrow(() -> new EntityNotFoundException("Agent not found"));
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
