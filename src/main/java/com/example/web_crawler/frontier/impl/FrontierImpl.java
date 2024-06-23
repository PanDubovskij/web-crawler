package com.example.web_crawler.frontier.impl;

import com.example.web_crawler.frontier.Frontier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Component
public class FrontierImpl implements Frontier {

    private static final String SEED = "https://www.wikipedia.org/";

    private final Queue<String> frontier = new PriorityQueue<>(List.of(SEED));

    @Override
    public void add(String url) {
        frontier.offer(url);
    }

    @Override
    public String getNext() {
        return frontier.poll();
    }
}
