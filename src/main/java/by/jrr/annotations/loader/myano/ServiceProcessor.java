package by.jrr.annotations.loader.myano;

import by.jrr.annotations.loader.AppLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static by.jrr.annotations.loader.AppLoader.*;

public class ServiceProcessor {

    public void process(Class... classes) {
        for (Class clazz : classes) {
            try {
                processAnnotation(clazz);
            } catch (Exception ex) {

            }

        }
    }

    private void processAnnotation(Class clazz) {
        if (isService(clazz)) {
            try {
                serviceContext.put(clazz.getSimpleName(), getInstance(clazz));
            } catch (Exception ex) {
                System.out.println(clazz.getSimpleName() + "could not been created");
            }
        }

     }

    private boolean isService(Class clazz) {
        return clazz.isAnnotationPresent(Service.class);
    }

    private Object getInstance(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> clazzConstructor = clazz.getConstructor();
        return clazzConstructor.newInstance();
    }



}
