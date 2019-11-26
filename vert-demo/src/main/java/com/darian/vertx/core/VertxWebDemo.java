package com.darian.vertx.core;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.util.Objects;

public class VertxWebDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        // 路由
        Router router = Router.router(vertx);


        // 创建 Http Server
        router.get("/echo").handler(context -> {
            // 请求
            HttpServerRequest request = context.request();
            String message = request.getParam("message");

            // 响应
            HttpServerResponse response = request.response();
            response.end("Hello: [ message ]:" + message);
        }); // 监听 8080 端口……

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
