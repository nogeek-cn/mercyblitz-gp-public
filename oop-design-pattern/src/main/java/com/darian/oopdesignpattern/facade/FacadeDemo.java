package com.darian.oopdesignpattern.facade;



public class FacadeDemo {
    public static void main(String[] args) {

    }
    private static class ServiceA{
        private void save(){
        }
    }
    private static class ServiceB{
        private void save(){
        }
    }

    private static class ServiceFacade{
        private ServiceA serviceA;
        private ServiceB serviceB;
        private void service(){
            serviceA.save();
            serviceB.save();
        }
    }
}
