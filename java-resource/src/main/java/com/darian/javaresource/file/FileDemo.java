package com.darian.javaresource.file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        // 这个文件的路径在什么地方
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.err.println(System.getProperty("user.dir"));
    }
}
