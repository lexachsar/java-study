package com.lexach.netcracker.theory.io.streams.homework;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws IOException {

        File txtFile = new File("src/com/lexach/netcracker/IOStreams/homework/enc.txt");
        File jpgFile = new File("src/com/lexach/netcracker/IOStreams/homework/pic.jpg");

        try {
            // Декодируем файл.
            Decoder.decode(txtFile, jpgFile);
        } catch (FileNotFoundException txtException) {
            // Если .txt файл не найден, кодируем файл .jpg
            System.out.println("File enc.txt not found.");
            System.out.println("Searching for pic.jpg file...");

            try {
                // Кодируем файл.
                Encoder.encode(jpgFile, txtFile);
            } catch (FileNotFoundException jpgException) {
                // Если ни один из файлов не найден, отменяем операцию.
                System.out.println("Files enc.txt and pic.jpg not found.");
            }
        }
    }
}