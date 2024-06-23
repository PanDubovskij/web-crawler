package com.example.web_crawler;

import com.example.web_crawler.crawler.Crawler;
import com.example.web_crawler.crawler.impl.CrawlerImpl;
import com.example.web_crawler.fetcher.impl.FetcherImpl;
import com.example.web_crawler.frontier.impl.FrontierImpl;
import com.example.web_crawler.parser.impl.ParserImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCrawlerApplication {

    static Crawler crawler = new CrawlerImpl(new FetcherImpl(), new ParserImpl(), new FrontierImpl());

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlerApplication.class, args);
        int i = 0;
        while (i < 5) {
            crawler.crawl();
            i++;
        }
    }

}
