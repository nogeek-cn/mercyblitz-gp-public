package concurrent.legacy;

import java.util.Observable;

/***
 * 观察者模式 Demo
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // 第一个缺点： Vector 作为底层存储（全线程安全的）
        // 第二个缺点，没有实现泛型
        // 第三个阙殆你： 同步 -> 阻塞
        MyObserable observable = new MyObserable();// 构建观察对象
        // 增加了第一个观察者
        observable.addObserver((o, arg) -> {
            System.out.println("第一个--观察到的数值：" + arg);
        });
        // 增加了第二个观察者
        observable.addObserver((o, arg) -> {
            System.out.println("第二个--观察到的数值：" + arg);
        });

        // 设置变化值
        observable.setChanged();
        observable.notifyObservers(1212321);
    }

    private static class MyObserable extends Observable {
        public void setChanged() {
            super.setChanged();
        }
    }
}
