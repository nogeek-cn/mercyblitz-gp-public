package com.darian.javai18ndemo.javase;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * {@link java.text.SimpleDateFormat}
 */
public class DateFormatDemo implements Runnable {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
    }

    @Override
    public void run() { // 重进入
        System.out.println(dateFormat.format(new Date()));
    }
}
