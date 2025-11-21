package com.example.restconf.service;

import com.example.restconf.model.NetworkConfig;
import com.example.restconf.repository.NetworkConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkConfigService {
    private final NetworkConfigRepository repo;

    public NetworkConfigService(NetworkConfigRepository repo) {
        this.repo = repo;
    }

    public NetworkConfig create(NetworkConfig config) {
        return repo.save(config);
    }

    public NetworkConfig update(Long id, NetworkConfig updated) {
        NetworkConfig existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Config not found: " + id));
        existing.setName(updated.getName());
        existing.setIpAddress(updated.getIpAddress());
        existing.setVendor(updated.getVendor());
        existing.setDescription(updated.getDescription());
        return repo.save(existing);
    }

    public NetworkConfig getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Config not found: " + id));
    }

    public List<NetworkConfig> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Config not found: " + id);
        }
        repo.deleteById(id);
    }
}
