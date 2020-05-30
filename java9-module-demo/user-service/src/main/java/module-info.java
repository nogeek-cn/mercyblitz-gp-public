/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  18:24
 */
module user.service {

    // transitive 传递依赖
    requires transitive user.domain;
    requires java.logging;
    // 依赖未经模块化的 Java 9 之前的 jar
    requires org.slf4j;

    // 导出
    // 1. 本模块的 public class 需要显示的 exports
    // 2. exports 不支持子包传递
    exports com.darian.service;
    exports com.darian.service.impl;
}