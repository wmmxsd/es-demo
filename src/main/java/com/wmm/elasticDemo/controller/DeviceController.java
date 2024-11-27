package com.wmm.elasticDemo.controller;

import com.wmm.elasticDemo.model.Device;
import com.wmm.elasticDemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.wmm.elasticDemo.utils.RandomDataUtil.getIp;
import static com.wmm.elasticDemo.utils.RandomDataUtil.getMac;

@RestController
@RequestMapping("device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("init")
    public void init() {
        int total = 5000;
        int curNum = 1;
        LocalDateTime before = LocalDateTime.now();
        while (curNum < total) {
            List<Device> deviceList = new ArrayList<>();
            for (int num = 0; num < 500; num++) {
                deviceList.add(new Device(curNum, String.valueOf(curNum), getIp(), getMac()));
                curNum++;
            }
            deviceService.saveAll(deviceList);
        }
        long time = Duration.between(before, LocalDateTime.now()).toMillis();
        System.out.println("total time:" + time);
    }

    @PostMapping("test")
    public void test() {
        int curNum = 1;
        int index = 0;
        long total = 0;
        while (index < 50) {
            LocalDateTime before = LocalDateTime.now();
            List<Device> deviceList = new ArrayList<>();
            for (int num = 0; num < 2000; num++) {
                deviceList.add(new Device(curNum, String.valueOf(curNum), getIp(), getMac()));
                curNum++;
            }
            deviceService.saveAll(deviceList);
            long time = Duration.between(before, LocalDateTime.now()).toMillis();
            total += time;
            System.out.println(time);
            index++;
        }
        System.out.println("total time:" + total);
    }



    @GetMapping("all")
    public Iterator<Device> all() {
        return deviceService.findAll();
    }

    @DeleteMapping("all")
    public void deleteAll() {
        deviceService.deleteAll();
    }

    @GetMapping("findByIp")
    public Device findByIp(String ip) {
        return deviceService.findByIp(ip);
    }

    @GetMapping("getByIp")
    public Device getByIp(String ip) {
        return deviceService.getByIp(ip);
    }

    @GetMapping("findByMac")
    public Device findByMac(String mac) {
        return deviceService.findByMac(mac);
    }

    @GetMapping("findByIdGreaterThan")
    public List<Device> findByIdGreaterThan(Integer id) {
        return deviceService.findByIdGreaterThan(id);
    }

    @GetMapping("page")
    public Page<Device> page(Integer page, Integer size) {
        return deviceService.page(PageRequest.of(page, size));
    }
}
