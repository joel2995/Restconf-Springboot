package com.example.restconf.controller;

import com.example.restconf.model.NetworkConfig;
import com.example.restconf.service.NetworkConfigService;
import io.micrometer.core.instrument.MeterRegistry;   // 🔵 ADDED
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restconf/data/network-configs")
public class NetworkConfigController {

    private final NetworkConfigService service;

    private final MeterRegistry meterRegistry;    // 🔵 ADDED

    public NetworkConfigController(NetworkConfigService service, MeterRegistry meterRegistry) {  // 🔵 UPDATED
        this.service = service;
        this.meterRegistry = meterRegistry;      // 🔵 ADDED
    }

    @PostMapping
    public ResponseEntity<NetworkConfig> create(@RequestBody NetworkConfig config) {
        NetworkConfig created = service.create(config);

        // 🔵 CUSTOM METRIC — increment counter for POST operations
        meterRegistry.counter("nms.network.config.created.count").increment();

        URI location = URI.create(String.format("/restconf/data/network-configs/%d", created.getId()));
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public List<NetworkConfig> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public NetworkConfig getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public NetworkConfig update(@PathVariable Long id, @RequestBody NetworkConfig config) {
        return service.update(id, config);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
