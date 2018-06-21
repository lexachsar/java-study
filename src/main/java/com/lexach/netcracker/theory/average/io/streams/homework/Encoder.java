package com.lexach.netcracker.theory.average.io.streams.homework;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Encoder {

    public static void encode(File jpgFile, File txtFile) throws IOException {
        // Создание потока фалового ввода.
        FileInputStream inputStream = new FileInputStream(jpgFile);

        // Создание массива байт, размерностью 50000
        byte[] arr = new byte[50000];

        // Чтение из потока файлового ввода 50000 байт, их запись в массив arr и
        // запись следующего после 50000 байта в l или запись -1 в l, если конец файла pic.png достигнут
        int l = inputStream.read(arr,0,50000);
        arr = Arrays.copyOfRange(arr,0, l);

        // Создание объекта класса "BASE64Encoder", предназанченного для
	    // кодирования данных с использованием стандарта Base64.
        BASE64Encoder encoder = new BASE64Encoder();
	    // Кодирование данных и их запись в строку st.
        String st = encoder.encode(arr);

	    // Создание потока файлового вывода.
        FileOutputStream outputStream = new FileOutputStream(txtFile);
	    // Запись байт из строчки st в файловый поток outputStream.
	    outputStream.write(st.getBytes(), 0, st.getBytes().length);

	    // Закрытие файловых потоков.
        inputStream.close();
        outputStream.close();

        // Удаление файла pic.jpg
        if(jpgFile.delete()) {
            System.out.println("File pic.jpg encoded and removed.");
        } else {
            System.out.println("Sile pic.jpg encoded, but not removed. Please, remove it manually.");
        }
    }


}
