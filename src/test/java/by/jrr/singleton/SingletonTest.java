package by.jrr.singleton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void singletonUsage() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        boolean isEqual = instance1 == instance2;

        assertSame(instance1, instance2);
    }

}
