/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Others;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 *
 * @author hjw12
 */
public class ExchangeRate {
    public static void main(String[] args) throws IOException{
        
        String url="https://finance.naver.com/marketindex/exchangeDetail.naver?marketindexCd=FX_USDKRW";
        
        Document doc = Jsoup.connect(url).get();
        
        Elements e1 = doc.getElementsByAttributeValue("class", "no_today");
        
        System.out.println(e1.text());
       
    } 
}
