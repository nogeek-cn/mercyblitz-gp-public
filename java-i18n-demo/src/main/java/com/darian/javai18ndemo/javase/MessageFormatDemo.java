package com.darian.javai18ndemo.javase;

import java.text.MessageFormat;

/***
 * {@link java.text.MessageFormat}
 */
public class MessageFormatDemo {
    public static void main(String[] args) {
        // Formatter 是 JAVA 5 里边的。
        MessageFormat format = new MessageFormat("Hello,{0} , {1}!");

        System.out.println(format.format(new String[]{"world","darian"}));
    }
}
