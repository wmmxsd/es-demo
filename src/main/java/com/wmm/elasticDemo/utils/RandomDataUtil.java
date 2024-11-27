package com.wmm.elasticDemo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataUtil {
    private static final List<String> IP_LIST = new ArrayList<>();

    private static final List<String> MAC_LIST = new ArrayList<>();

    private static final char[] MAC_CHAR_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Random RANDOM = new Random();

    public static String getIp() {
        String ip = RANDOM.nextInt(256) + "." + RANDOM.nextInt(256) + "." + RANDOM.nextInt(256) + "." + RANDOM.nextInt(256);
        if (IP_LIST.contains(ip)) {
            ip = getIp();
        } else {
            IP_LIST.add(ip);
        }
        return ip;
    }

    public static String getMac() {
        String mac = RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)] + "-"
                             + RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)] + "-"
                             + RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)] + "-"
                             + RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)] + "-"
                             + RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)] + "-"
                             + RANDOM.nextInt(10) + MAC_CHAR_ARRAY[RANDOM.nextInt(6)];
        if (MAC_LIST.contains(mac)) {
            mac = getMac();
        } else {
            MAC_LIST.add(mac);
        }
        return mac;
    }
}
