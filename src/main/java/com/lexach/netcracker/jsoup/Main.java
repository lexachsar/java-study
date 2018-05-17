package com.lexach.netcracker.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.wildberries.ru").get();

        String title = doc.title();

        Elements links = doc.select("a[href]");

        for (Element link : links) {

            // get the value from href attribute
            System.out.println("\nLink : " + link.attr("href"));
            System.out.println("Text : " + link.text());
        }

        System.out.println("title is" + title);

    }
}
