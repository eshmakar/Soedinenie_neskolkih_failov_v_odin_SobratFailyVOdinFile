package com.test;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class JoinFiles {
    public JoinFiles() throws IOException {
    }

    private static final String p = "D:/CLCK.RU/"; //ИСХОДЯЩИЕ ФАЙЛЫ ЗДЕСЬ
    private static final File files = new File(p);
    private static final String[] arr = files.list();//получаем список и сохраняем их в массив

    public static void main(String[] args) throws IOException {
        //OUTPUT FILE
        BufferedWriter f = new BufferedWriter(new FileWriter(p + "\\outputFile.txt", true));//Выходящий файл будет таким именем

        for (int i = 0; i < Objects.requireNonNull(arr).length; i++) {
            String path = (files + "\\" + arr[i]); //ПРОХОДИМ ПО КАЖДОМУ ФАЙЛУ
            BufferedReader b = new BufferedReader(new FileReader(path));//текущий входящий файл
            Scanner scanner = new Scanner(b);

            while (scanner.hasNextLine())
                f.write(scanner.nextLine() + "\n");


            f.flush();
            scanner.close();
            b.close();
        }
        System.out.println("GOTOVO");


    }
}
