/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Stocksearch;

/**
 * 테스트
 *
 * @author ijaeyeong
 */
import static com.mycompany.layout.Stockchart.Live_Stock_Price;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoogleFinanceCrawler {

    private String stockprice = "";
    private String stockCode = "";
    private String stockExchange = "";

    public GoogleFinanceCrawler(String stockName) {
        try {
           
            TickerCreator tickerCreator = new TickerCreator(stockName);
            String stockCode = tickerCreator.getStockCode();
            String stockExchange = tickerCreator.getStockExchange();
            System.out.println(stockCode + ":" + stockExchange);
            
            
            
            new Thread(() -> {
                while (true) {
                    try {
                        String url = "https://www.google.com/finance/quote/" + stockCode + ":" + stockExchange;
                        Document doc = Jsoup.connect(url).get();
                        Element stockPriceElement = doc.getElementsByClass("YMlKec fxKbKc").first();

                        if (stockPriceElement != null) {
                            String stockPrice = stockPriceElement.text();
                            Live_Stock_Price.setText(stockPrice);
                        } else {
                            Live_Stock_Price.setText("Stock price not found");
                        }

                        Thread.sleep(500);
                    } catch (IOException e) {
                        Live_Stock_Price.setText("Error fetching stock data");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        } catch (IOException ex) {
            Logger.getLogger(GoogleFinanceCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public GoogleFinanceCrawler(String StockName) {
//
//        try {
//            TickerCreator tickerCreator = new TickerCreator(StockName);
//            stockCode = tickerCreator.getStockCode();
//            stockExchange = tickerCreator.getStockExchange();
//            System.out.println(stockCode + ":" + stockExchange);
//
//        } catch (IOException e) {
//            System.err.println("Error fetching stock data: " + e.getMessage());
//        }
//
//    }
//
//    public String getStockPrice() throws IOException {
//
//       
//            
//            String url = "https://www.google.com/finance/quote/" + this.stockCode + ":" + this.stockExchange;
//            Document doc = Jsoup.connect(url).get();
//            this.stockprice = doc.getElementsByClass("YMlKec fxKbKc").first().text();
//            System.out.print(this.stockprice);
//            return this.stockprice;
//
//        
//
//    }
//
//}
    public static void main(String[] args) {

    }
}
