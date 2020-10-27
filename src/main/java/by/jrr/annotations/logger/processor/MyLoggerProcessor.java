package by.jrr.annotations.logger.processor;

import by.jrr.annotations.logger.example.MyLogger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyLoggerProcessor {

    public static void process(Object object) {
        try {
            reflect(object);
        } catch (IllegalAccessException  ex) {
            ex.printStackTrace();
        }
    }

    private static void reflect(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        if(clazz.isAnnotationPresent(MyLogger.class)) {
            Map<String, String> fieldMap = new HashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                fieldMap.put(field.getName(), field.get(object).toString());
            }
            System.out.println(clazz.getName() + "\n\t" + getJson(fieldMap));
        }
    }

    private static String getJson(Map<String, String> filelds) {
        String result = filelds.entrySet()
                .stream()
                .map((entry) -> entry.getKey()+"="+entry.getValue())
                .collect(Collectors.joining(",","{","}"));
        return result;
    }
}
