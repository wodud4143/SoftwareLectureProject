/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multiThread;

import com.mycompany.Stocksearch.GoogleFinanceCrawler;
import com.mycompany.Stocksearch.TESTca;
import com.mycompany.Stocksearch.TickerCreator;
import static com.mycompany.layout.MyPage.stockList;
import static com.mycompany.layout.StockChart.Live_Stock_Price;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author ijaeyeong
 */
public class MultiThread extends Thread {
    
    private String stockprice = "";
    private String stockCode = "";
    private String stockExchange = "";
    private String stockName = "";
    private int index;

    
    public MultiThread (String stockName, int index) {
        this.stockName = stockName;
        this.index = index;
    }
    
    
    @Override
    public void run() {
       try {
            TickerCreator tickerCreator = new TickerCreator(stockName);
            String stockCode = tickerCreator.getStockCode();
            String stockExchange = tickerCreator.getStockExchange();
            System.out.println(stockCode + ":" + stockExchange);
            
            while (true) {
                try {
                    String url = "https://www.google.com/finance/quote/" + stockCode + ":" + stockExchange;
                    Document doc = Jsoup.connect(url).get();
                    Element stockPriceElement = doc.getElementsByClass("YMlKec fxKbKc").first();
                    
                    if (stockPriceElement != null) {
                        String stockPrice = stockPriceElement.text();
                        System.out.print(stockPrice);
                        stockList.setValueAt(stockPrice, index, 3);
                        
                        double purchasePrice = (double)stockList.getValueAt(index, 1);
                        double currentPrice = Double.parseDouble(stockPrice.replaceAll("[^0-9.-]", ""));
                        double profit = ((currentPrice - purchasePrice) / purchasePrice) * 100;
                        
                        stockList.setValueAt(String.format("%.2f", profit) + "%", index, 4);
                        
                    } else {
                        stockList.setValueAt("Stock price not found", index, 3);
                    }
                    
                    Thread.sleep(500);
                } catch (IOException e) {
                    Live_Stock_Price.setText("Error fetching stock data");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TESTca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
