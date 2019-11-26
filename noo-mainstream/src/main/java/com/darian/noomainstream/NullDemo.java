package com.darian.noomainstream;


import java.util.Objects;

public class NullDemo {
    public static void main(String[] args) {
        Object object = null;
        System.out.println(Objects.isNull(object));
    }

    /***
     *Before 7
     */
    private static boolean isnNull(Object object) {
        return object == null;
    }
}
