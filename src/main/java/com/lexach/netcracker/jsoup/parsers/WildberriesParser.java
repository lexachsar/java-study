package com.lexach.ClothingFeed.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WildberriesParser extends AbstractParser {

    WildberriesParser() {
        super("https://www.wildberries.ru");

        this.menCategory = "https://www.wildberries.ru/catalog/muzhchinam/odezhda";
        this.womenCategory = "https://www.wildberries.ru/catalog/zhenshchinam/odezhda";
        this.childrenCategory = "https://www.wildberries.ru/catalog/detyam/odezhda";
    }

    @Override
    public Elements parseRoot() {
        return null;
    }

    @Override
    public Elements parseCategory(String categoryLink) {
        return null;
    }

    @Override
    public Elements parseProduct() {
        return null;
    }
}
