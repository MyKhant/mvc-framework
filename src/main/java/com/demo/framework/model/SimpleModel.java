package com.demo.framework.model;

import com.demo.framework.model.Model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model {
    private Map<String,String> map = new HashMap<>();
    @Override
    public void set(String name, String value) {
        map.put(name,value);
    }

    @Override
    public String get(String name) {
        return map.get(name);
    }
}
