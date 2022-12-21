package com.demo.framework.util;

import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationControllerFinder {
    public Map<String , IController> findControllers(){
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::classAsIController)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }
    private Class<IController> classAsIController(Class<?> controller){
        return (Class<IController>) controller;
    }
    private IController getControllerInstance(Class<IController> iController){
        try {
            return iController.getConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException(
                    String.format("%s cannot create instance cause %s",
                            iController.getClass().getSimpleName(), e.getMessage())
            );
        }
    }
    public String getUri(IController iController){
        return iController.getClass().getAnnotation(ControllerMapping.class).value();
    }
}
