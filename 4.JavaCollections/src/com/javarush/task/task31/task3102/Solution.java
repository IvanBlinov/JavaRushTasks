package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<File> dirs = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        dirs.add(new File(root));
        for(File dir : dirs) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    dirs.add(file);
                } else {
                    paths.add(file.getAbsolutePath());
                }
            }
        }
        return paths;
    }

    public static void main(String[] args) throws IOException {
        List<String> paths = getFileTree("D:\\Films");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
