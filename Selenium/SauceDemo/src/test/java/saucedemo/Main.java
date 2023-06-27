package saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//For Title class
		 String actualtitle = driver.getTitle();
	     System.out.println("Page title: " + actualtitle);
		
		
		//login
	 
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");	    
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	  
	    //wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    //add to cart
	    
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    //wait
	    Thread.sleep(1000);
	    
	    //shopping cart
	    driver.findElement(By.className("shopping_cart_link")).click();
	    
	    //wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    //checkout
	    driver.findElement(By.id("checkout")).click();
	    
	     
	   //wait
	    Thread.sleep(1000);
	    
	    
	    //continue
	    driver.findElement(By.id("first-name")).sendKeys("abc");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("last-name")).sendKeys("xyz"); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("postal-code")).sendKeys("1206");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.id("continue")).click();
	    
	   //wait
	    Thread.sleep(2000);
	    
	    //finish
	    driver.findElement(By.id("finish")).click();
	    
	   //wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    //back to home
	    
	    driver.findElement(By.id("back-to-products")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.id("react-burger-menu-btn")).click();
	    
	    //wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	    
	    //logout
	    driver.findElement(By.id("logout_sidebar_link")).click();
	    
	    driver.close();




	}

}
