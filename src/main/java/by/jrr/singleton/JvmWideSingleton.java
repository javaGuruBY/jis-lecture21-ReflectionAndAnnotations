package by.jrr.singleton;

import java.util.Properties;

public final class JvmWideSingleton
{
    private static final JvmWideSingleton INSTANCE;

    static {
        // There should be just one system class loader object in the whole JVM.
        synchronized(ClassLoader.getSystemClassLoader()) {
            Properties sysProps = System.getProperties();
            // The key is a String, because the .class object would be different across classloaders.
            JvmWideSingleton singleton = (JvmWideSingleton) sysProps.get(JvmWideSingleton.class.getName());

            // Some other class loader loaded JvmWideSingleton earlier.
            if (singleton != null) {
                INSTANCE = singleton;
            }
            else {
                // Otherwise this classloader is the first one, let's create a singleton.
                // Make sure not to do any locking within this.
                INSTANCE = new JvmWideSingleton();
                System.getProperties().put(JvmWideSingleton.class.getName(), INSTANCE);
            }
        }
    }

    public static JvmWideSingleton getSingleton() {
        return INSTANCE;
    }
}
