package com.darian.demos;



import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> valueList = Arrays.asList(1, 2, 3, 4, 5);

        // 包含 5 个完整的数据
        Iterator<Integer> iterator = valueList.iterator();
        while (iterator.hasNext()) { // 被动的内容
            Integer value = iterator.next(); // 客户端主动请求
            if (value % 2 == 0) {  // 判断是否为偶数
                System.out.println(value);
            } else {
                // 奇数仍然还是产生了
            }
        }
    }

    /****
     * 服务端推送数据 1，2，3，4，5
     * 客户端只要 1，2，3
     * 客户端 cancel 命令通知服务端推送 4，5
     */
//    public void update(Integer value , Request request) {
//        if(value == 3){
//            request.concel();
//        }
//    }
}
