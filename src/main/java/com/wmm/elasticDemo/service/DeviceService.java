package com.wmm.elasticDemo.service;

import com.wmm.elasticDemo.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;

public interface DeviceService {
    void save(Device device);

    void saveAll(List<Device> list);

    Iterator<Device> findAll();

    void deleteAll();

     long count();

     Long getMaxId();

    Device findByIp(String ip);

    Device getByIp(String ip);

    Device findByMac(String mac);

    List<Device> findByIdGreaterThan(Integer id);

    Page<Device> page(Pageable pageable);
}
