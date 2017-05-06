/**
 * 
 */
package com.Asos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Khushboo Taneja
 *
 */
public class WomenClothes {

	WebDriver driver = new FirefoxDriver();// creating FirefoxDriver Session
	
	@Before
	public void setUp() throws InterruptedException
	{
		driver.get("http://www.asos.com");//get the url
		driver.manage().window().maximize();//maximize the window
		 Thread.sleep(3000);
        WebElement menu=driver.findElement(By.xpath("//span[text()='WOMEN']")); // get the xpath of hover link women
        Actions action =new Actions(driver);// perform an action for hover functionality
        action.moveToElement(menu);//moveToElement method for moving an element in hover
        action.build().perform();//finally perform the action
        System.out.println("-----Menu Tab of WOMEN---- ");//print the value
        Thread.sleep(6000); //wait for 6ms
        driver.findElement(By.xpath("//a[text()='Tops']")).click();//click on tops link on hover of women
        Thread.sleep(3000);
	}
	
	//@Test
	public void women() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Petite']")).click();//select the Range 'Petite' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Tall']")).click();//select the Range 'Tall' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Pink']")).click();//select the colour 'Pink' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Grey']")).click(); //select the colour 'Red' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='UK 6']")).click();//select the Size '6' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Long Sleeve']")).click();//select the Sleeve 'Long Sleeve' from left side checkbox
        }
	
	//@Test
	public void clear() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Petite']")).click();//select the Range 'Petite' from left side checkbox
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Tall']")).click();//select the Range 'Tall' from left side checkbox
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[text()='Clear'])[1]"));//clear the data
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Pink']")).click();//select the colour 'Pink' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Grey']")).click(); //select the colour 'Red' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='UK 6']")).click();//select the Size '6' from left side checkbox
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Long Sleeve']")).click();//select the Sleeve 'Long Sleeve' from left side checkbox
        driver.findElement(By.xpath("(//a[text()='Clear All'])[1]"));//clear All the data(not working)
        System.out.println("----Clear all the data-----------");
        }
	
	//@Test
	public void sorting() throws InterruptedException {
		WebElement sortBy=driver.findElement(By.id("sortBy"));//make an xpath of dropdown box
        Select dropDown=new Select(sortBy);//Select is a class
        dropDown.selectByVisibleText("Our favourites");//selecting the text/value from dropdown
        Thread.sleep(3000);
        dropDown.selectByVisibleText("What's new");
        Thread.sleep(3000);
        dropDown.selectByVisibleText("Price high to low");
        Thread.sleep(3000);
        dropDown.selectByVisibleText("Price low to high");
       }
	
   @Test
	public void mousehoverImage() throws InterruptedException {
	  Thread.sleep(3000);
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;// cresting session of jse script
	  jse.executeScript("window.scrollBy(0,300)", "");//to scrolldown the page
	  //jse.executeScript("window.scrollBy(0,-300)", ""); //to scrollup the page
	  
	  WebElement mainImage= driver.findElement(By.xpath("(//img[@class='product-img'])[1]"));//women top-section on hover
	  //mainImage.click();
	  Thread.sleep(3000);
	  Actions action=new Actions(driver);
	  action.moveToElement(mainImage);
	  action.build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='product-interactions']"));//sub image(Quickview,Save wala div) in Main Image
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='quickview js-quickview']")).click();//quickview link on hover
	  Thread.sleep(3000);
	  WebElement dropDown= driver.findElement(By.xpath("//select[@class='size-dropdown']"));
	  Select select=new Select(dropDown);
      select.selectByVisibleText("UK 4");//select the size
      Thread.sleep(3000);
      }
   

   //@Test
	public void linkofImage() throws InterruptedException {
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//span[text()='ASOS Tee with Asymmetric Ruffle Hem in Yellow Floral']")).click();//click on product name
	   Thread.sleep(3000);
	   WebElement dropDown=driver.findElement(By.xpath("(//select[@data-id='sizeSelect'])[1]"));//to select the value from dropdown
	   Select select=new Select(dropDown);
       select.selectByVisibleText("UK 4");//select the size
       Thread.sleep(3000);
   }
   
@After
public void tearDown()
{
	driver.close();//session close
}

}
