package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tickercreater {
    String stockCode ="";
    String stockExchange ="";

    Tickercreater(String StockName) throws IOException {
        String searchQuery = StockName +" 주가"; // 검색어
        String url = "https://www.google.com/search?q=" + searchQuery; // 검색 결과 URL
        Document doc = Jsoup.connect(url).get(); // HTML 문서 가져오기
        // 검색 결과에서 링크 추출
        String input = doc.getElementsByClass("r0bn4c rQMQod").text();
        if (input.contains("NASDAQ")) {
            Pattern pattern = Pattern.compile("");

            String prefix = "";
            Pattern pattern1 = Pattern.compile("\\b\\p{Upper}{1,}\\b"); // 대문자 알파벳 정규식 패턴
            Matcher matcher1 = pattern1.matcher(input);
            if (matcher1.find()) {
                prefix = matcher1.group(); // 대문자 알파벳 추출
            }
            //System.out.println(prefix);


            if(input.contains("폐장 후:")){
                pattern = Pattern.compile("^.*: (.*)[(]([A-Z]+)[)]"); // 정규식 패턴
            }else {
                pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]");
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                stockCode = prefix; // 005930
                stockExchange = matcher.group(2); // KRX
                System.out.println("Stock Code: " + prefix);
                System.out.println("Stock Exchange: " + stockExchange);
            }

        }else{
            Pattern pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]"); // 정규식 패턴
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                stockCode = matcher.group(1); // 005930
                stockExchange = matcher.group(2); // KRX
                System.out.println("Stock Code: " + stockCode);
                System.out.println("Stock Exchange: " + stockExchange);
            }
        }
    }
    String getStockCode(){
        return stockCode;
    }
    String getStockExchange(){
        return stockExchange;
    }

}
