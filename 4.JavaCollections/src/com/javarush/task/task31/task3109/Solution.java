package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        File file = new File(fileName);
        try {
            int extPoint = fileName.lastIndexOf('.');
            String extension = fileName.substring(extPoint + 1);
            if (extension.equals("xml")) {
                FileInputStream fis = new FileInputStream(file);
                properties.loadFromXML(fis);
                return properties;
            } else {
                properties.load(new FileReader(file));
            }
        } catch (Exception e) {

        }
        return properties;
    }
}
