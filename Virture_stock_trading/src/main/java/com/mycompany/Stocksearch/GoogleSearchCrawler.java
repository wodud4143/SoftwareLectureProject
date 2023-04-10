package com.mycompany.Stocksearch;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchCrawler {
    public static void main(String[] args) throws IOException {
        String searchQuery = "테슬라 주가"; // 검색어
        String url = "https://www.google.com/search?q=" + searchQuery; // 검색 결과 URL
        Document doc = Jsoup.connect(url).get(); // HTML 문서 가져오기
        // 검색 결과에서 링크 추출

        String input = doc.getElementsByClass("r0bn4c rQMQod").text();
        System.out.println(input);
        if (input.contains("NASDAQ")) {
            Pattern pattern = Pattern.compile("");

            String prefix = "";
            Pattern pattern1 = Pattern.compile("\\b\\p{Upper}{1,}\\b"); // 대문자 알파벳 정규식 패턴
            Matcher matcher1 = pattern1.matcher(input);
            if (matcher1.find()) {
                prefix = matcher1.group(); // 대문자 알파벳 추출
            }
            System.out.println(prefix); // 출력: TSLA


            if(input.contains("폐장 후:")){
                pattern = Pattern.compile("^.*: (.*)[(]([A-Z]+)[)]"); // 정규식 패턴
            }else {
                pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]");
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String stockCode = matcher.group(1); // 005930
                String stockExchange = matcher.group(2); // KRX
                System.out.println("Stock Code: " + prefix);
                System.out.println("Stock Exchange: " + stockExchange);
            }

        }else{
            Pattern pattern = Pattern.compile("^(.*)[(]([A-Z]+)[)]"); // 정규식 패턴
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String stockCode = matcher.group(1); // 005930
                String stockExchange = matcher.group(2); // KRX
                System.out.println("Stock Code: " + stockCode);
                System.out.println("Stock Exchange: " + stockExchange);
            }
        }


    }
}
