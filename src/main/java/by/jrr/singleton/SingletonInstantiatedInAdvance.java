package by.jrr.singleton;

public class SingletonInstantiatedInAdvance {

    private final static SingletonInstantiatedInAdvance instance = new SingletonInstantiatedInAdvance();

    private SingletonInstantiatedInAdvance() {

    }

    public static SingletonInstantiatedInAdvance getInstance() {
        return instance;
    }
}
