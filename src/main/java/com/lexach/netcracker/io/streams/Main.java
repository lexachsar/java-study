package com.lexach.netcracker.io.streams;

import com.sun.org.apache.xpath.internal.axes.FilterExprWalker;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void printIMOKToFile() throws IOException {
        String myPath = "src/main/java/com/lexach/netcracker/IOStreams/myfile.txt";

        File myFile = new File(myPath);

        FileOutputStream fileOutStream = new FileOutputStream(myFile);

        DataOutputStream dataOutputStream = new DataOutputStream(fileOutStream);

        dataOutputStream.write(73);
        dataOutputStream.write(77);
        dataOutputStream.write(79);
        dataOutputStream.write(75);

        dataOutputStream.flush();
        dataOutputStream.close();

        fileOutStream.close();
    }

    public static void main(String[] args) throws IOException {
        // Вывод IMOK в файл.
        printIMOKToFile();

        // Стандартная кодировка системы.
        System.out.println(String.valueOf(Charset.defaultCharset()));
    }
}
