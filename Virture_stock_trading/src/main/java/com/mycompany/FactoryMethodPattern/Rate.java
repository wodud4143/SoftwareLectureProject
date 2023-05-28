/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FactoryMethodPattern;

/**
 *
 * @author hjw12
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

public class Rate {
	String connUrl="https://kr.investing.com/currencies/usd-krw";
	
	public String getRate() throws Exception{
		Document doc = Jsoup.connect(connUrl).get();
		Elements e1 = doc.getElementsByAttributeValue("data-test", "instrument-price-last");
		return e1.text();
	}
}
