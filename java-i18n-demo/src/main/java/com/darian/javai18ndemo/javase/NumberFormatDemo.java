package com.darian.javai18ndemo.javase;

import java.text.NumberFormat;
import java.util.Locale;

/***
 *{@link java.text.NumberFormat} 实例
 */
public class NumberFormatDemo {
    public static void main(String[] args) {

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(10000));
        numberFormat = NumberFormat.getNumberInstance(Locale.FRANCE);
        System.out.println(numberFormat.format(10000));
    }
}
