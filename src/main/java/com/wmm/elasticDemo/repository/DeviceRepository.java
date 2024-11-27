package com.wmm.elasticDemo.repository;

import com.wmm.elasticDemo.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends ElasticsearchRepository<Device, Integer> {
    Optional<Device> findByIp(String ip);
    Optional<Device> getByIp(String ip);
    Optional<Device> findByMac(String mac);
    List<Device> findByIdGreaterThan(Integer id);
}
