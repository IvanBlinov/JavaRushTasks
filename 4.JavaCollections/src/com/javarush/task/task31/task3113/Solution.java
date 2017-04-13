package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    static int dirCount = 0;
    static int fileCount = 0;
    static long fileBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirPath = reader.readLine();
        reader.close();
        Path path = Paths.get(dirPath);
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
            return;
        }

        Files.walkFileTree(path,new myFileVisitor());
        System.out.println("Всего папок - " + (dirCount - 1));
        System.out.println("Всего файлов - " + fileCount);
        System.out.println("Общий размер - " + fileBytes);
    }

    static class myFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (Files.isDirectory(dir)) dirCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!Files.isDirectory(file)) {
                fileCount++;
                fileBytes+= Files.size(file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
