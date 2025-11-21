package com.example.restconf.repository;

import com.example.restconf.model.NetworkConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkConfigRepository extends JpaRepository<NetworkConfig, Long> {
}
