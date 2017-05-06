/**
 * 
 */
package com.ak.testing.flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/**
 * @author Khushboo Taneja
 *
 */
public class Shirt2 {
	WebDriver driver = new FirefoxDriver();

	public void hoverTest() throws InterruptedException {
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		//Code with Click Functions
		
		WebElement mainMenu = driver.findElement(By.xpath("//a[@title='Men']"));
		mainMenu.click();
		System.out.println("----Main END----");
		Thread.sleep(3000);
		
		WebElement subMenu = driver.findElement(By.xpath("//a[@title='Shirts']"));
		subMenu.click();
		Thread.sleep(20000);
		System.out.println("----Sub Menu END----");
		*/
		
		//Code With Hover
		
		WebElement mainMenu = driver.findElement(By.xpath("//a[@title='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainMenu).build().perform();
		System.out.println("----Main END----");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
//		WebElement subMenu = driver.findElement(By.xpath("//a[@title='Shirts']"));
//		subMenu.click();
		Thread.sleep(3000);
		System.out.println("----Sub Menu END----");
		
		
		/*Actions action = new Actions(driver);
		action.moveToElement(mainMenu).build().perform();
		System.out.println("Main Menu is open");
		driver.findElement(By.linkText("Shirts")).click();*/
	}
	

	  public void listofitem() throws InterruptedException
	  {
		WebElement checkbox= driver.findElement(By.xpath("//div[text()='S']"));
		checkbox.click();
		Thread.sleep(20000);
	  }
	  
	  public void color() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//div[@class='_1O37ie _1GEhLw']/text()='Beige')")).click();
		  Thread.sleep(20000);
		  driver.findElement(By.xpath("//a[text()='Highlander Men's Solid Casual Grey Shirt']")).click();
		  WebElement size= driver.findElement(By.xpath("//*[@id='swatch-0-size']/a"));
		  Assert.assertEquals(size, "//*[@id='swatch-0-size']/a");
		  driver.close();
	  }
	public static void main(String[] args) throws InterruptedException {
		Shirt2 sh = new Shirt2();
		sh.hoverTest();
		//sh.listofitem();
		sh.color();
	}
}
