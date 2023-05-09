/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Others;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author hjw12
 */


public class ExchangeRate extends Thread{
	
   public static void main(String[] args){
	   Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Rate rate=new Rate();
		    	String changeRate;
				try {
					changeRate = rate.getRate();
					System.out.println("현재 환율="+changeRate);
                                        
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable,0,10,TimeUnit.SECONDS);
  } 
}
