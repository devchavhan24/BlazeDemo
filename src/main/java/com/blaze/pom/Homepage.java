package com.blaze.pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	public WebDriver ldriver;


	public Homepage(WebDriver rdriver) {
		ldriver=rdriver;

		PageFactory.initElements(ldriver,this);
	}

	@FindBy (linkText="destination of the week! The Beach!") private WebElement destination;
	@FindBy (xpath="//select[@name='fromPort']") private WebElement Departure;
	@FindBy (xpath="//select[@name='toPort']") private WebElement Destination;
	@FindBy (xpath=".//input[@type='submit']") private WebElement FindFlights;
	@FindBy (xpath="//table[@class='table']//ancestor::tr//input[@name='price']") private List<WebElement> price;
	@FindBy (xpath="//p[text()='Total Cost: ']//em") private WebElement Tcost;
	@FindBy (xpath="//*[@value='Purchase Flight']") private WebElement Purchase;
	@FindBy (xpath="//*[@class='table']//tbody/tr//td[text()='Id']//following-sibling::td") private WebElement Id;
	

	public String getTitle() {
		return  ldriver.getTitle();



	}

	public void clickOnDestination(String vacation) throws InterruptedException
	{
		destination.click();
		System.out.println("Sucessfully click on destination");
		Thread.sleep(5000);
		String vac=ldriver.getCurrentUrl();
		System.out.println("Sucessfully fetch the Current Url: "+vac);
		if(vac.contains(vacation)) {
			ldriver.navigate().back();
			System.out.println("Sucessfully Navigate back to the Home Page");
		}	
	}

	public void findFlights(String dep, String dest) throws InterruptedException {

		Select select=new Select(Departure);
		select.selectByVisibleText(dep);
		System.out.println("Sucessfully select Departure City as: "+dep);
		Thread.sleep(2000);
		Select select2=new Select(Destination);
		select2.selectByVisibleText(dest);
		System.out.println("Sucessfully select Destination City as: "+dest);
		Thread.sleep(2000);
		FindFlights.click();
		System.out.println("Sucessfully click on Find Flights");

	}
	public void lowestprice() throws InterruptedException
	{
		List< WebElement> lowest=ldriver.findElements(By.xpath("//table[@class='table']//ancestor::tr//input[@name='price']"));

		double min = 0;
		ArrayList<Double> list = new ArrayList<>();
		for(WebElement s: lowest) {
			String a = s.getAttribute("value");
			double v = Double.parseDouble(a);
			list.add(v);

		}
		if(!list.isEmpty())
		{
			Collections.sort(list);

			min = list.get(0);
			System.out.println(list);
			System.out.println("Min value is " + min);
		}

		String str=Double.toString(min);
		ldriver.findElement(By.xpath("//*[@value='[Text]']//ancestor::tr//td".replace("'[Text]'",str))).click();

	}
	

	public String validatationcost() {
		return Tcost.getText().replaceAll("[^.]","x");
	}
	
	public void Purchase()
	{
		Purchase.click();
		System.out.println("Sucessfully click on purchase");
	}
	public String getID() {
		return Id.getText();
		
	}

}