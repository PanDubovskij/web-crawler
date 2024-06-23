package com.example.web_crawler.fetcher;

import org.jsoup.nodes.Document;

public interface Fetcher {

    Document fetch(String url);
}
