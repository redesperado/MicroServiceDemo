package com.example.provider.serviceImpl;

import com.example.common.redisCfg.RedisClient;
import com.example.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProvideServiceImpl implements ProviderService {

    @Autowired
    private RedisClient redisClient;

    @Override
    public String sayHello2Consumer(String s) {
        System.out.println("provider s : " + s);
        return s;
    }

    /**
     * 设置key，value存入redis
     *
     * @param key
     * @param value
     * @param time
     */
    @Override
    public void setValue(String key, Object value, long time) {
        redisClient.set(key, value, time);
    }

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    @Override
    public String getValue(String key) {

        return redisClient.get(key) == null ? "redis key time out" : redisClient.get(key);
    }

}
