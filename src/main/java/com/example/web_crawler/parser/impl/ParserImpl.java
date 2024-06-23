package com.example.web_crawler.parser.impl;

import com.example.web_crawler.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParserImpl implements Parser {
    @Override
    public List<String> getLinks(Document document) {
        Elements elements = document.select("a[href]");
        List<String> links = new ArrayList<>();
        elements.forEach(element -> {
            links.add(element.absUrl("href"));
        });
        return links;
    }

    @Override
    public void parse(Document document) {
    }
}
