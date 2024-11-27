package com.wmm.elasticDemo.service.impl;

import com.wmm.elasticDemo.model.Device;
import com.wmm.elasticDemo.repository.DeviceRepository;
import com.wmm.elasticDemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void saveAll(List<Device> list) {
        deviceRepository.saveAll(list);
    }

    @Override
    public Iterator<Device> findAll() {
        return deviceRepository.findAll().iterator();
    }

    @Override
    public void deleteAll() {
        deviceRepository.deleteAll();
    }

    @Override
    public long count() {
        return deviceRepository.count();
    }

    @Override
    public Long getMaxId() {
        return 1L;
    }

    @Override
    public Device findByIp(String ip) {
        return deviceRepository.findByIp(ip).orElse(null);
    }

    @Override
    public Device getByIp(String ip) {
        return deviceRepository.getByIp(ip).orElse(null);
    }

    @Override
    public Device findByMac(String mac) {
        return deviceRepository.findByMac(mac).orElse(null);
    }

    @Override
    public List<Device> findByIdGreaterThan(Integer id) {
        return deviceRepository.findByIdGreaterThan(id);
    }

    @Override
    public Page<Device> page(Pageable pageable) {
        return deviceRepository.findAll(pageable);
    }
}
