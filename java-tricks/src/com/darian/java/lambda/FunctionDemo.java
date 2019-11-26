package com.darian.java.lambda;


import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        DefaultServiceInvoker<UserService> serviceInvoker =
                new DefaultServiceInvoker<>(new UserService());

        String name = serviceInvoker.invoke(userService -> {
            return userService.findName(2L);
        });
        // Reactor
    }

    public static class UserService{
        public String findName(Long id){
            return "Hello, World";
        }
    }

    public interface ServiceInvoker<T> {

        <R> R invoke(Function<T,R> func);
    }

    public static class DefaultServiceInvoker<T>
            implements ServiceInvoker<T>{

        private final T service;

        public DefaultServiceInvoker(T service) {
            this.service = service;
        }


        @Override
        public <R> R invoke(Function<T, R> func) {
            return func.apply(service);
        }
    }
}
