package com.blaze.test;
import java.text.DecimalFormat;

import org.testng.annotations.Test;

import com.blaze.driver.driver;
import com.blaze.pom.Homepage;  

public class HpageTest extends driver {
	
@Test
public static void Assessment() {
	Homepage page=new Homepage(driver);
	try {
		
	String title=page.getTitle();
	if(title.equalsIgnoreCase("Welcome to the Simple Travel Agency!")) {
		System.out.println("This is the Home Page of  application");
	}
	page.clickOnDestination("vacation");
	page.findFlights("Mexico City","London");
	page.lowestprice();
	
	String cost=page.validatationcost();
	System.out.println("Price is availabel with xxx.xx format : "+cost);
	page.Purchase();
	String purchasepage=page.getTitle();
	if(purchasepage.equalsIgnoreCase("Thank you for your purchase today!")) {
		System.out.println("This is the Purchase Page of  application");
	}
	String id=page.getID();
	System.out.println("Purchase Id Is: "+id);
	
	
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	

	    
	
}
}
