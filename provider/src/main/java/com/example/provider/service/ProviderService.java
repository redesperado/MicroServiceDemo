package com.example.provider.service;

public interface ProviderService {

    String sayHello2Consumer(String s);

    void setValue(String key, Object value, long time);

    String getValue(String key);

}
