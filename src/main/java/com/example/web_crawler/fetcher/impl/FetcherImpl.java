package com.example.web_crawler.fetcher.impl;

import com.example.web_crawler.fetcher.Fetcher;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FetcherImpl implements Fetcher {

    private static final Logger logger = LoggerFactory.getLogger(Fetcher.class);

    @Override
    public Document fetch(String url) {
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0");
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return document;
    }
}
