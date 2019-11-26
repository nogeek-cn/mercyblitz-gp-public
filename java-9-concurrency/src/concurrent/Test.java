package concurrent;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
//        long start1 = System.currentTimeMillis();
//
//        for (int i = 0; i < 1000000000; i++) {
//            incr(1, 1000000);
//        }
//        long end1 = System.currentTimeMillis();
//
//        long start2 = System.currentTimeMillis();
//        for (int i = 0; i < 1000000000; i++) {
//            incrw(1, 1000000);
//        }

//        long end2 = System.currentTimeMillis();
        System.out.println(incr(1,1000000));
//        System.out.println(incrw(1,1000000));
//
//        System.out.println(end1-start1);
//        System.out.println(end2-start2);

    }

    public static int incr(int m, int n) {
        return (m + n) * (n - m + 1) >> 1;
    }

    public static int incrw(int m, int n) {
        return (m + n) * (n - m + 1) / 2;
    }





}
