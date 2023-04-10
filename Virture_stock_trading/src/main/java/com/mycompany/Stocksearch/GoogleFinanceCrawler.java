package com.mycompany.Stocksearch;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleFinanceCrawler {
    public static void main(String[] args) {
        String stockprice ="";
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하고 싶은 주식을 입력하세요: ");
        String stockName = sc.next();

        try {
            TickerCreator tickerCreator = new TickerCreator(stockName);
            String stockCode = tickerCreator.getStockCode();
            String stockExchange = tickerCreator.getStockExchange();
            System.out.println(stockCode + ":" + stockExchange);

            while (true) {
                String url = "https://www.google.com/finance/quote/" + stockCode + ":" + stockExchange;
                Document doc = Jsoup.connect(url).get();
                stockprice=doc.getElementsByClass("YMlKec fxKbKc").first().text();
                System.out.println(stockprice);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.err.println("Error fetching stock data: " + e.getMessage());
        }
    }
}
