package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File result = new File(args[1]);

        String newName = result.getParent() + "/allFilesContent.txt";
        FileUtils.renameFile(result, new File(newName));

        ArrayList<File> files = new ArrayList<>();
        getFiles(folder,files);

        for (File file : files) {
            if (file.length() > 50) {
                FileUtils.deleteFile(file);
                files.remove(file);
            }
        }

        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = new FileOutputStream(result);
        for (File file : files) {
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
        }
        fileOutputStream.close();
        if (fileInputStream != null) fileInputStream.close();

    }

    public static void getFiles (File directory, ArrayList<File> files) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                if (file.length() == 0) {
                    file.delete();
                } else {
                    getFiles(file,files);
                }
            } else {
                files.add(file);
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
