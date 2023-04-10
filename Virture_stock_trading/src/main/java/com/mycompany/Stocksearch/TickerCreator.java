package com.mycompany.Stocksearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TickerCreator {
    private String stockCode = "";
    private String stockExchange = "";

    public TickerCreator(String stockName) throws IOException {
        String searchQuery = stockName + " 주가";
        String url = "https://www.google.com/search?q=" + searchQuery;
        Document doc = Jsoup.connect(url).get();

        String input = doc.getElementsByClass("r0bn4c rQMQod").text();
        String prefix = "";
        Pattern pattern1 = Pattern.compile("\\b\\p{Upper}{1,}\\b");
        Matcher matcher1 = pattern1.matcher(input);
        if (matcher1.find()) {
            prefix = matcher1.group();
        }

        Pattern pattern;
        if (input.contains("NASDAQ")) {
            if (input.contains("폐장 후:")) {
                pattern = Pattern.compile("^.*: (.*)[(]([A-Z]+)[)]");
            } else {
                pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]");
            }
        } else {
            pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]");
        }

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            stockCode = input.contains("NASDAQ") ? prefix : matcher.group(1);
            stockExchange = matcher.group(2);
        }
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getStockExchange() {
        return stockExchange;
    }
}
