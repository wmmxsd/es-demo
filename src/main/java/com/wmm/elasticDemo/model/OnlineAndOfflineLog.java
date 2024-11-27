package com.wmm.elasticDemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

import static org.springframework.data.elasticsearch.annotations.DateFormat.hour_minute_second;
import static org.springframework.data.elasticsearch.annotations.DateFormat.year_month_day;

public class OnlineAndOfflineLog {
    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private Integer deviceId;

    @Field(type = FieldType.Byte)
    private Integer onlineOrOffline;
    @Field(type = FieldType.Date, pattern = ("yyyy-MM-dd HH:mm:ss"))
    private LocalDateTime time;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Ip)
    private String ip;

    @Field(type = FieldType.Text)
    private String mac;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getOnlineOrOffline() {
        return onlineOrOffline;
    }

    public void setOnlineOrOffline(Integer onlineOrOffline) {
        this.onlineOrOffline = onlineOrOffline;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
