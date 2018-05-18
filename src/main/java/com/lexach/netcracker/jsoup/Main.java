package com.lexach.netcracker.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String linkNext = "https://www.wildberries.ru/catalog/zhenshchinam/odezhda?page=1";

        while (true) {

            Document doc = Jsoup.connect(linkNext).get();

            //Elements links = doc.select("a[href]");

            Elements links = doc.getElementsByClass("catalog-prev-link");

            linkNext = "https://wildberries.ru/" + doc.getElementsByClass("next").first().attr("href");


            System.out.println(linkNext);

            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nLink : " + link);
                System.out.println("Text : " + link.text());
            }

            String title = doc.title();
            System.out.println("title is" + title);
        }
    }
}
