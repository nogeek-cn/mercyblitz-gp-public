package com.darian.oopdesignpattern.adapter;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        // 目前拥有的实例
        InputStream inputStream = new FileInputStream("aaa");
        // 需要的对象
        // InputStream -> Reader
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        print(reader);
    }

    private static void print(Reader reader){
    }
}
