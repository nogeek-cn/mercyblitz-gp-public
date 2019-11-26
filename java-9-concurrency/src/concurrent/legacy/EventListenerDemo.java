package concurrent.legacy;

import java.beans.PropertyChangeSupport;

/***
 * 事件监听者模式
 * {@link java.util.EventObject} 标准的事件对象
 * {@link java.util.EventListener} 标准的事件监听对象
 * @see java.util.EventListener
 */
public class EventListenerDemo {
    public static void main(String[] args) {
        Person person = new Person();
        // JAVA Beans 规范 -> 内省
        // propertyChangeEvent 广播源
        // PropertyChangeListener 注册器
        PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(person);
        propertyChangeSupport.addPropertyChangeListener("name", evt -> {
            Person bean = (Person) evt.getSource();
            System.out.println("【Person】：" + bean + "\n，[旧值]："
                    + evt.getOldValue() + ",【新值】" + evt.getNewValue());
        });

        // 触发事件
        propertyChangeSupport.firePropertyChange("name",
                null, "darian");
    }

    /***
     * Pojo getter / setter
     */
    public static class Person {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
