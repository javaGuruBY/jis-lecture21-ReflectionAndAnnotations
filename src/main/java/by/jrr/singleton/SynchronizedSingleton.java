package by.jrr.singleton;

public final class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {

    }

    public static synchronized SynchronizedSingleton getInstance() {
        if(instance == null) {
            synchronized (SynchronizedSingleton.class) {
                if(instance == null) {
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }
}
