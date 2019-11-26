package com.darian.oopdesignpattern.bridge;

import java.sql.SQLOutput;

public class BirdgeDemo {
    public static void main(String[] args) {
        ScanService scanService = new scanServiceImpl(new ScanbuyService() {
            @Override
            public void buy() {
                System.out.println("JD 扫码购物");
            }
        }, null);

        // scanService.scanBuy() -> scanBuyService.buy();
        // 对于客户端而言，只关注与粗粒度接口，具体执行方法是由运行时初始化而定。
        scanService.scanbuy();


         scanService = new scanServiceImpl(new ScanbuyService() {
            @Override
            public void buy() {
                System.out.println("TaoBao 扫码购物");
            }
        }, null);

    }

    static class scanServiceImpl implements ScanService {
        private ScanbuyService scanbuyService;
        private ScanLoginService scanLoginService;

        scanServiceImpl(ScanbuyService scanbuyService, ScanLoginService scanLoginService) {
            this.scanbuyService = scanbuyService;
            this.scanLoginService = scanLoginService;
        }

        @Override
        public void scanbuy() {
            scanbuyService.buy();
        }

        @Override
        public void scanLogin() {
            scanLoginService.login();
        }
    }

    interface ScanService {
        void scanbuy();

        void scanLogin();
    }

    interface ScanbuyService {
        void buy();
    }

    interface ScanLoginService {
        void login();
    }
}
