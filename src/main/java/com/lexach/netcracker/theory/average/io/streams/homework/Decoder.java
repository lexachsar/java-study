package com.lexach.netcracker.theory.average.io.streams.homework;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decoder {

    public static void decode(File txtFile, File jpgFile) throws IOException {
        // Создание потока фалового ввода.
        FileInputStream inputStream = new FileInputStream(txtFile);

	    // Сoздание объекта класса "Base64Decoder", предназначенного для
	    // декодирования данных с использованием стандарта "Base64"
	    BASE64Decoder decoder = new BASE64Decoder();


        // Декодирование данных и их запись в строчку st.
	    byte[] arr = decoder.decodeBuffer(inputStream);

    	// Создание потока файлового вывода. Запись в него массива arr.
        FileOutputStream outputStream = new FileOutputStream(jpgFile);
        outputStream.write(arr, 0, arr.length);



	    // Закрытие файловых потоков.
        inputStream.close();
        outputStream.close();

        // Удаление файла enc.txt
        if(txtFile.delete()) {
            System.out.println("File enc.txt decoded and removed.");
        } else {
            System.out.println("Sile enc.txt decoded, but not removed. Please, remove it manually.");
        }

    }
}
