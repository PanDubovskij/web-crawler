package com.example.web_crawler.parser;

import org.jsoup.nodes.Document;

import java.util.List;

public interface Parser {
    List<String> getLinks(Document document);

    void parse(Document document);
}
