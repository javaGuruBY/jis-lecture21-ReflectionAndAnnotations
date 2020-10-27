package by.jrr.reflections.service;

import by.jrr.reflections.bean.Car;

import java.awt.image.CropImageFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionService {

    public void getClazz() throws ClassNotFoundException {
        Car car = new Car();
        Class<? extends Car> varClass = car.getClass();
        Class<Car> classClass = Car.class;
        Class<?> nameClass = Class.forName("by.jrr.reflections.bean.Car");
    }

    public void reflectionMethodsOverview() throws NoSuchFieldException, NoSuchMethodException {
        Class<Car> carClass = Car.class;
        String v1 = carClass.getName(); // полное имя с пакетом
        String v2 = carClass.getSimpleName(); // краткое имя
        int v3 = carClass.getModifiers(); // модификаторы доступа
        Class<? super Car> v4 = carClass.getSuperclass(); // получить от родителя
        Class<?>[] v5 = carClass.getInterfaces(); // получить интерфейсы, но не получит интрефейсы супер класса
        ClassLoader v6 = carClass.getClassLoader(); // получить класслоадер

        Field[] f1 = carClass.getFields(); // только публичные
        Field[] f2 = carClass.getDeclaredFields(); // и приватные, но только текущего класса
        Field f3 = carClass.getField("model");  // взять конкретное поле

        Method[] m1 = carClass.getMethods(); // только публичные
        Method[] m2 = carClass.getDeclaredMethods(); // и приватные, но только текущего класса
        Method m3 = carClass.getMethod("getColorCode", String.class, int.class); //String.class

        Constructor<?>[] c1 = carClass.getConstructors();// только публичные
        Constructor<?>[] c2 = carClass.getDeclaredConstructors(); // и приватные, но только текущего класса
        Constructor<Car> c3 = carClass.getConstructor(String.class);
    }

    public void createNewInstance() throws
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException {
        Class<?> carClass = Car.class;
        Car object = (Car) carClass.newInstance();

        Constructor<?> carConstructor = carClass.getConstructor();
        Car object2 = (Car) carConstructor.newInstance();
    }

    public void invokeMethods() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> carClass = Car.class;
        Method carMethod = carClass.getMethod("getColorCode", String.class);
        Object[] args = new Object[] {new String("myColor")};

        carMethod.invoke(new Car(), args);
    }

    public void getFields() throws NoSuchFieldException, IllegalAccessException {
        Class<?> carClass = Car.class;
        Field carField = carClass.getField("model");
        Object result = carField.get(new Car());
        System.out.println("result = " + result);
    }

    public void  workWithPrivate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> carClass = Car.class;

        Method carMethod = carClass.getDeclaredMethod("getPrivateColorCode", String.class);
        Field carField = carClass.getDeclaredField("model");
        carField.setAccessible(true);
        carMethod.setAccessible(true);

        Object[] args = new Object[] {new String("myColor")};
        carMethod.invoke(new Car(), args);

        Car myCar = new Car();
        carField.set(myCar, "New Value");

        Object result = carField.get(myCar);
        System.out.println("result = " + result);
    }
}
