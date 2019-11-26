package com.darian.io.file.monitor;

import sun.awt.SunHints;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;

public class FileMonitoring {
    public static void main(String[] args) throws IOException, InterruptedException {
        File userDir = new File(System.getProperty("user.dir"));
        long lastModified = userDir.lastModified();
        List<String> subFiles = list(userDir.list());
        while (true) {
            // 文件最后的修改事件
            if (lastModified == userDir.lastModified()) {
                continue;
            }
            // 保存一份现有的文件
            List<String> newSubFiles = list(userDir.list());
            // 1. 增加文件
//            newSubFiles.removeAll(subFiles); // 剩余的文件

            List<String> finalSubFiles = subFiles;
            newSubFiles.stream()
                    .filter(s -> !finalSubFiles.contains(s))
                    .forEach(value -> out.println("新增的文件：" + value));

            finalSubFiles.stream()
                    .filter(s -> !newSubFiles.contains(s))
                    .forEach(value -> out.println("删除的文件：" + value));


            lastModified = userDir.lastModified();
            subFiles = list(userDir.list());
        }
    }

    private static <T> List<T> list(T... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    private static void println() {
        File file = new File("");
        out.println("[用户工作目录]: " + file.getAbsolutePath());
        // 用户目录，用户工作目录
        out.println("[用户目录]：" + System.getProperty("user.home"));
        out.println("[用户工作目录]: " + System.getProperty("user.dir"));
    }


}
