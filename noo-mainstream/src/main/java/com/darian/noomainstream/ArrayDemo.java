package com.darian.noomainstream;


import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        String[] values = values();
        ObjectUtils.isEmpty(values);



    }

    /***
     * 性能和内存
     * @return
     */
    private static List<String> list() {
        // ArrayList 的默认大小，请告诉我你的 JAVA 版本。
        return new ArrayList<>();
    }

    private static String[] values() {
        return null;
    }
}
