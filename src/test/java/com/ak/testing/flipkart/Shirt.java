/**
 * 
 */
package com.ak.testing.flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Khushboo Taneja
 *
 */
public class Shirt {
	WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws InterruptedException {
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Code With Hover
		WebElement mainMenu = driver.findElement(By.xpath("//a[@title='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainMenu).build().perform();
		System.out.println("----Main END----");
		Thread.sleep(3000);

	}

	// @Test
	public void hoverTest() throws InterruptedException {

		driver.findElement(By.xpath("//a[@title='Shirts']")).click();
		Thread.sleep(3000);
		System.out.println("----Sub Menu END----");

		WebElement checkbox = driver.findElement(By.xpath("//div[text()='S']"));
		checkbox.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()=\"Highlander Men's Solid Casual Grey Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement size = driver.findElement(By.xpath("(//a[@class='_2_26Ng _5FnwXU'])[1]"));
		System.out.println("size of shirt  :: " + size.getText());
		Assert.assertEquals("S", size.getText());
	}

	// @Test
	public void sizeTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		System.out.println("----Sub Menu END----");

		WebElement checkbox = driver.findElement(By.xpath("//div[text()='S']"));
		checkbox.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()=\"Kay Dee Solid Men's Round Neck Grey, Black T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement size = driver.findElement(By.xpath("(//a[@class='_2_26Ng _5FnwXU'])[2]"));
		System.out.println("size of shirt  :: " + size.getText());
		Assert.assertEquals("M", size.getText());

	}

	// @Test
	public void brand() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Wrangler']"));
		checkbox.click();
		// driver.findElement(By.xpath("(//span[text()='Clear all'])[1]"));
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"Wrangler Printed Men's Round Neck Red T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement brand = driver.findElement(By.xpath("//h1[@class='_3eAQiD']/text()"));
		System.out.println("brand of shirt  :: " + brand.getText());
		// Assert.assertEquals("M", size.getText());
	}

	// @Test
	public void sleeve() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='3/4 Sleeve']"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"Cult Fiction Printed Men's Round Neck White T-Shirt\"])[1]"))
				.click();
		Thread.sleep(6000);
		WebElement brand = driver.findElement(By.xpath("(//li[text()='3/4 Sleeve'])[1]"));
		System.out.println("brand of shirt  :: " + brand.getText());
		// Assert.assertEquals("M", brand.getText());
	}

	// @Test
	public void type() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("(//div[text()=\"Draped Neck\"])[2]"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"Hypernation Solid Men's Draped Neck Black, Grey T-Shirt\"])[1]"))
				.click();
		Thread.sleep(6000);
		WebElement type = driver.findElement(By.xpath("//h1[@class='_3eAQiD']/text()"));
		System.out.println("brand of shirt  :: " + type.getText());
		// Assert.assertEquals("M", size.getText());
	}

	// @Test
	public void pattern() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Argyle']"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("(//a[text()=\"Wear Your Mind Argyle Men's Round Neck Orange, Black, Grey T-Shir...\"])[1]"))
				.click();
		Thread.sleep(6000);
		WebElement pattern = driver.findElement(By.xpath("//h1[@class='_3eAQiD']/text()"));
		System.out.println("brand of shirt  :: " + pattern.getText());
		// Assert.assertEquals("M", size.getText());
	}

	//@Test
	public void discount() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='20% or More']"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"Bigidea Solid Men's Henley Grey, Dark Blue T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement discount = driver.findElement(By.xpath("(//div[text()='60'])[1]"));
		System.out.println("disount on shirt  :: " + discount.getText());
		Assert.assertEquals("60% off", discount.getText());
	}

	
	//@Test
	public void color() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Blue']"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"SayItLoud Solid Men's Round Neck Blue, Blue T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement discount = driver.findElement(By.xpath("(//div[text()='60'])[1]"));
		System.out.println("disount on shirt  :: " + discount.getText());
		Assert.assertEquals("60% off", discount.getText());
	}
	
	
	//@Test
	public void offer() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Special Price']"));
		checkbox.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()=\"Adidas Solid Men's Polo Neck Blue T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		WebElement offer = driver.findElement(By.xpath("//span[text()='Special Price']"));
		System.out.println("disount on shirt  :: " + offer.getText());
		Assert.assertEquals("Special Price", offer.getText());
	}
	
	
	//@Test
	public void theme() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[text()='Theme']")).click();
		Thread.sleep(6000);
		WebElement checkbox= driver.findElement(By.xpath("//div[text()='Indigo']"));
		checkbox.click();
		driver.findElement(By.xpath("(//a[text()=\"Adidas Solid Men's Polo Neck Blue T-Shirt\"])[1]")).click();
		Thread.sleep(6000);
		//WebElement theme = driver.findElement(By.xpath("//span[text()='Special Price']"));
		//System.out.println("disount on shirt  :: " + theme.getText());
		//Assert.assertEquals("Special Price", theme.getText());
	}
	
	@Test
	public void searchBrand() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@class='_1wT-Zr'])[1]")).sendKeys("wrang");//i want dynamically
		Thread.sleep(6000);
		WebElement checkbox= driver.findElement(By.xpath("//div[text()='Wrangler']"));
		System.out.println("The searching text is : " + checkbox.getText());
		Assert.assertEquals("Wrangler", checkbox.getText());
		}
	
	public void tearDown() {
		driver.close();
	}
}
