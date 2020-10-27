package by.jrr.reflections.service;

import by.jrr.reflections.bean.Car;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class ReflectionServiceTest {

    Logger log = LoggerFactory.getLogger("");

    @Test
    public void reflectionMethodsOverview() {
        Class<Car> carClass = Car.class;
        log.info(carClass.getName()); // полное имя с пакетом
        log.info(carClass.getSimpleName()); // краткое имя
        log.info(""+carClass.getModifiers()); // модификаторы доступа
        log.info(""+carClass.getSuperclass()); // получить от родителя
        log.info(""+carClass.getInterfaces()); // получить интерфейсы, но не получит интрефейсы супер класса
        log.info(""+carClass.getClassLoader()); // получить класслоадер
    }

    @Test
    public void invokeMethods() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        var reflectionService = new ReflectionService();
        reflectionService.invokeMethods();
    }

    @Test
    public void getField() throws IllegalAccessException, NoSuchFieldException {
        var reflectionService = new ReflectionService();
        reflectionService.getFields();
    }
    @Test
    public void workWithPrivate() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        var reflectionService = new ReflectionService();
        reflectionService.workWithPrivate();
    }

}
