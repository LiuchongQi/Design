package com.company.adapter;

import java.io.*;

/**
 * 转换器模式
 */
public class App {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("d:\\sql联合注入.txt");
//             InputStreamReader及是转换器
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);)
        {
            String line;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
