package com.example.web_crawler.crawler.impl;

import com.example.web_crawler.crawler.Crawler;
import com.example.web_crawler.fetcher.Fetcher;
import com.example.web_crawler.frontier.Frontier;
import com.example.web_crawler.parser.Parser;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrawlerImpl implements Crawler {

    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);


    private final Fetcher fetcher;
    private final Parser parser;
    private final Frontier frontier;

    public CrawlerImpl(Fetcher fetcher, Parser parser, Frontier frontier) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.frontier = frontier;
    }

    @Override
    public void crawl() {
        String url = frontier.getNext();
        Document document = fetcher.fetch(url);
        List<String> links = parser.getLinks(document);
        for (String link : links) {
            frontier.add(link);
            logger.info(link);
        }
//        List<String> content = getContent(document);
    }
}
