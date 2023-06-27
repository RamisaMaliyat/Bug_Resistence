package opencart;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;


public class Main {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
	    driver.manage().window().maximize();	
		//title 
		
		String actualtitle= driver.getTitle();
		System.out.println(actualtitle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//My Account
		
		driver.findElement(By.xpath("//span[@class='d-none d-md-inline' and text() = 'My Account']")).click(); //for same class name use text attribute

		driver.findElement(By.xpath("//a[@class='dropdown-item' and text()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abc@gmail.com");	
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123");
		Thread.sleep(1000);
		
		WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
		button.sendKeys(Keys.ENTER);   //sendKeys(Keys.ENTER) simulates pressing the Enter key as if a user has pressed it on their keyboard.(click function not working)
		
		//Email verification message
		WebElement validationMessage = driver.findElement(By.id("error-email"));
        if (validationMessage.isDisplayed()) 
        {
            System.out.println("Validation message: " + validationMessage.getText());
        }
		
		//Login
		driver.findElement(By.xpath("//a[@class='list-group-item'and text()='My Account']")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
		
		//For cart
		
		driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'and text()='Desktops']")).click();
		driver.findElement(By.xpath("//a[@class='see-all'and text()='Show All Desktops']")).click();
		Thread.sleep(1000);
		WebElement dropdown = driver.findElement(By.id("input-sort"));
		Select selectDropdown =new Select(dropdown);
		 
        WebElement selectedOption = selectDropdown.getFirstSelectedOption(); // Get the currently selected option
        String currentSelection = selectedOption.getText();

        if (!currentSelection.equals("Model (Z - A)")) // Select the desired option only if it is not already selected
        {
            selectDropdown.selectByValue("https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=20&sort=p.model&order=DESC");
        }
        
        WebElement button2 = driver.findElement(By.xpath("//body[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/button[1]"));
        button2.sendKeys(Keys.ENTER);
        
      //successful message
      	WebElement Message = driver.findElement(By.id("alert"));
              if (Message.isDisplayed()) 
              {
                  System.out.println("Validation message: " + Message.getText());
              }
         
        Thread.sleep(1000);      
        driver.navigate().to("https://demo.opencart.com/");
        
	}

}
