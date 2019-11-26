package com.darian.io.file.monitor;


import java.io.File;
import java.nio.file.*;
import java.util.List;

import static java.lang.System.*;

/***
 * 工具类的方法，sun 公司 喜欢 + s, 其它公司喜欢 + s
 * FileSystem FileSystems
 * Object Objects
 */
public class WatchServiceDemo {
    public static void main(String[] args) throws Exception {
        // 获取监视服务
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 文件对象
        File userDir = new File(getProperty("user.dir"));
        Path path = userDir.toPath();
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW);
        // WatchEvent 事件

        while (true) { // 轮询
            // 监听的钥匙
            WatchKey watchKey = watchService.poll();
            if (watchKey == null) {
                continue;
            }
            List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
            watchEvents.stream()
                    .map(watchEvent ->
                            "{文件：[" + String.valueOf(watchEvent.context()) + "]}\t"
                                    + "{变化：[" + String.valueOf(watchEvent.kind()) + "]}\t"
                                    + "{count:[" + String.valueOf(watchEvent.count() + "]}\t")
                    ).forEach(out::println);
        }
    }
}
