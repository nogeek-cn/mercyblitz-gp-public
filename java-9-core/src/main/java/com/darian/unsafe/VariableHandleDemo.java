package com.darian.unsafe;

import org.springframework.objenesis.ObjenesisException;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/31  3:16
 */
public class VariableHandleDemo {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        testVarHandle();

//        testUnSafe();
    }

    private static void testVarHandle() throws NoSuchFieldException, IllegalAccessException {
        A a = new A();

        VarHandle varHandle;

        varHandle = MethodHandles.lookup()
                .in(A.class)
                .findVarHandle(A.class, "value", String.class);


        // CAS = 首先比较对等性，然后才能设置
        varHandle.compareAndSet(a, "Hellxx", "World");
        System.out.println(a.value);

        varHandle.compareAndSet(a, "Hello", "World");
        System.out.println(a.value);
    }

    private static void testUnSafe() {
        // 报错，安全检查错误
        Unsafe.getUnsafe();

        // 会触发 JVM 挂掉
        unsafe.putInt(1L, 2);
    }

    private static Unsafe unsafe;

    static {
        Field f;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException var3) {
            throw new ObjenesisException(var3);
        }

        f.setAccessible(true);

        try {
            unsafe = (Unsafe) f.get((Object) null);
        } catch (IllegalAccessException var2) {
            throw new ObjenesisException(var2);
        }
    }

    public static class A {
        private String value = "Hello";
    }
}
