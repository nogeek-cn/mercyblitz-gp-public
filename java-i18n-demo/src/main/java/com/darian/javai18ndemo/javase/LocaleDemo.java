package com.darian.javai18ndemo.javase;

import java.util.Locale;

/***
 * {@link java.util.Locale}
 */
public class LocaleDemo {
    public static void main(String[] args) {


        // 通过启动参数调整 -D =》  System.setProperty();
        // 硬编码调整 en_US，无法做到一份代码，到处运行。
        Locale.setDefault(Locale.US);
        // 输入默认的 Locale
        System.out.println(Locale.getDefault());
    }
}
