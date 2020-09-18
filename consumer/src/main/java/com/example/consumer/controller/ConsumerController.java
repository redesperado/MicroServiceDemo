package com.example.consumer.controller;

import com.example.common.constants.Constants;
import com.example.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/hello")
    public void sayHello(){
        String str = providerService.sayHello2Consumer("Not hello, just hi. ");
        System.out.println("consumer get str = " + str + " from provide");
    }

    @GetMapping("/setValue")
    public String setValue(String key, String value){
        //设置key有效时间为10s，便于测试
        providerService.setValue(key,value, Constants.CACHE_EXP_TEN_SECONDS);
        return "key: " + key +" value: " + value;
    }

    @GetMapping("/getValue")
    public String getValue(String key){
        return providerService.getValue(key);
    }

}
