package com.darian.oopdesignpattern.composite;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeDemo {

    private static interface A{
        void save();
    }

    private static class AImpl implements A{
        @Override
        public void save() {
            System.out.println("save();");
        }
    }

    /**
     * 可实现可不实现
     **/
    private static class CompositeA implements A{
        private Collection<A> list = new ArrayList<>();
        @Override
        public void save() {
            list.forEach(a -> a.save());
        }
    }
}
