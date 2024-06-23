package com.example.web_crawler.frontier;

public interface Frontier {
    void add(String url);

    String getNext();
}
