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
import static com.mycompany.layout.StockChart.Live_Stock_Price;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.SingletonPattern.Stock;
import com.mycompany.layout.StockChart;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class TESTca extends Thread {

    private String stockprice = "";
    private String stockCode = "";
    private String stockExchange = "";
    private String stockName = "";
    
    public TESTca(String stockName){
        this.stockName = stockName;
    }
    


    



   
    @Override
    public void run() {
        
        
        

        try {
            TickerCreator tickerCreator = new TickerCreator(stockName);
            String stockCode = tickerCreator.getStockCode();
            String stockExchange = tickerCreator.getStockExchange();
            System.out.println(stockCode + ":" + stockExchange);
                    String dimageUrl ="https://ssl.pstatic.net/imgfinance/chart/item/candle/day/"+ stockCode +".png?sidcode=1685136002094";
                    String wimageUrl ="https://ssl.pstatic.net/imgfinance/chart/item/candle/week/"+ stockCode +".png?sidcode=1685136002094";
                    String mimageUrl ="https://ssl.pstatic.net/imgfinance/chart/item/candle/month/"+ stockCode +".png?sidcode=1685136002094";
                    
                    downloadImage(dimageUrl, stockCode + "_chart.png", "./image_day/");
                    downloadImage(wimageUrl, stockCode + "_chart.png", "./image_week/"); 
                    downloadImage(mimageUrl, stockCode + "_chart.png", "./image_month/");
            
            while (true) {
                try {
                    String url = "https://www.google.com/finance/quote/" + stockCode + ":" + stockExchange;
                    Document doc = Jsoup.connect(url).get();
                    Element stockPriceElement = doc.getElementsByClass("YMlKec fxKbKc").first();
                    
                    if (stockPriceElement != null) {
                        String stockPrice = stockPriceElement.text();
                        System.out.print(stockPrice);
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
        } catch (IOException ex) {
            Logger.getLogger(TESTca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
        public static void downloadImage(String imageUrl, String fileName, String destinationFolder) throws IOException {
        URL url = new URL(imageUrl);
        InputStream inputStream = url.openStream();

        Path outputPath = Path.of( destinationFolder,fileName);

        Files.copy(inputStream, outputPath, StandardCopyOption.REPLACE_EXISTING);

        inputStream.close();
    }
}


