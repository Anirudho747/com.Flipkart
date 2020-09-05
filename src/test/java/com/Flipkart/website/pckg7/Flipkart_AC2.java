package com.Flipkart.website.pckg7;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Flipkart_AC2 {
	
	WebDriver driver = null;
	
	 @Parameters("browser")
	 @BeforeClass
	  public void beforeClass(@Optional("firefox") String browser) {
		
   	  if(browser.equalsIgnoreCase("firefox")) {
   		 
   	//Initializing the firefox driver (Gecko)
   		  WebDriverManager.firefoxdriver().setup();
   		  driver = new FirefoxDriver();	  

   	  }else if (browser.equalsIgnoreCase("chrome")) { 

   		  WebDriverManager.chromedriver().setup();
   		  driver = new ChromeDriver();	
   	  }
   	  driver.manage().window().maximize();
	  }
	
		@Test(priority=3,enabled=true)
		public void getGoogle()
		{
			driver.get("https://www.google.com/");
			WebElement srchBar = driver.findElement(By.xpath("//input[@name='q']"));
			//Search for “Flipkart” 
			srchBar.sendKeys("Flipkart");
		}
			
		@Test(priority=4,enabled=true)
		public void getFlipkart()
		{  
			        WebElement srchBar = driver.findElement(By.xpath("//input[@name='q']"));
					//Print all the search options displayed in the console from google’s search field, while we write “Flipkart” in that. 
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(700));
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'sbtc')]//*[contains(@class,'sbl1')]")));
					List<WebElement> srchRslt = driver.findElements(By.xpath("//*[contains(@class,'sbtc')]//*[contains(@class,'sbl1')]"));
					for(WebElement w:srchRslt)
					{
						System.out.println(w.getText());
					}
					//Press enter to give out the search results and open the link for the “flipkart.com
					driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
					srchBar.sendKeys(Keys.ENTER);
					driver.findElement(By.xpath("//h3[text()='Flipkart']")).click();
		}
		
		@Test(priority=5,enabled=true)
		public void getwindowAC()
		{  
			//Close the login popup on the website (if available) 
					driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
					
					
					//Click on “TV & Appliances” dropdown button and Navigate to “AirConditioners > Window AC’s” page 
					driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and text()='TVs & Appliances']")).click();
					driver.findElement(By.xpath("//a[@title='Window ACs']")).click();
		}
		
		@Test(priority=6,enabled=true)
		public void getNameAndPrice()
		{  
			driver.findElement(By.xpath("//h1[text()='Window Air Conditioners']//following::div[@class='_3wU53n'][2]//following::div[@class='_1p7h2j'][1]")).click();
			driver.findElement(By.xpath("//h1[text()='Window Air Conditioners']//following::div[@class='_3wU53n'][2]//following::div[@class='_1p7h2j'][2]")).click();
			
			
			//Then Click on the COMPARE button.
			driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
			
			
			//In the 3rd column of the same page, you’ll find an option to add another product. In that Select “Samsung” from the BRAND Dropdown and select any product. 
			driver.findElement(By.xpath("//a[text()='Login']//following::div[text()='Choose Brand'][1]")).click();
			driver.findElement(By.xpath("//a[text()='Login']//following::div[text()='Choose Brand'][1]//following::div[@class='_2KISpu' and @title='Samsung'][1]")).click();
			driver.findElement(By.xpath("//a[text()='Login']//following::div[text()='Choose a Product'][1]")).click();
	/*		 for(int i=0; i<=7;i++)
		      { try{
		  //  driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]")).click();
		    	  driver.findElement(By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[3]")).click();    
		    	  break;
		 }
		 catch(Exception e){
		    System.out.println(e.getMessage());
		    System.out.println(e.getCause());
		 } }		
	*/
			
			
			//Print Name and price of all products in the console. 
			String Name1 = driver.findElement(By.xpath("//img[@title='Flipkart']//following::a[@class='_3YNWH1'][1]")).getText();
			String Name2 = driver.findElement(By.xpath("//img[@title='Flipkart']//following::a[@class='_3YNWH1'][2]")).getText();
			String Price1 = driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='_1vC4OE'][1]")).getText().substring(1);
			String Price2 = driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='_1vC4OE'][2]")).getText().substring(1);
			System.out.println(Name1+" comes at "+Price1);
			System.out.println(Name2+" comes at "+Price2);
		}
		
		@Test(priority=7,enabled=true)
		public void getCart()
		{  
			//Add all the products into the cart, one by one.
					String currURL = driver.getCurrentUrl();
					driver.findElement(By.xpath("//img[@title='Flipkart']//following::button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU'][1]")).click();
					driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
					driver.navigate().to(currURL);
					WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(700));
					wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@title='Flipkart']//following::div[@class='row'][2]")));
					driver.findElement(By.xpath("//img[@title='Flipkart']//following::button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU'][2]")).click();
		}
		
		@Test(priority=8,enabled=true)
		public void getAvailablity()
		{  
			//Go to the cart and add your area Pincode and check the availability of the product delivery there.
					WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(3400));
					wait4.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@title='Flipkart']//following::div[@class='_3gijNv col-12-12\'][2]")));
					
					for(int i=0; i<=7;i++)
				      { try{
				    	  driver.findElement(By.xpath("//div[@class='_2LG8B7']")).click();
				    	  driver.findElement(By.xpath("//input[@class='_20PCkk']")).sendKeys("226016");
				  		  driver.findElement(By.xpath("//input[@class='_20PCkk']")).sendKeys(Keys.ENTER);
				  		  driver.manage().timeouts().implicitlyWait(3400,TimeUnit.SECONDS);
						  //Print the message getting displayed for the availability/delivery of the product in the console
					      System.out.println(driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='bzD9az'][1]")).getText());
						  System.out.println(driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='bzD9az'][2]")).getText());
				    	  break;
				 	       }
				 	 catch(Exception e){
				 	    System.out.println(e.getMessage());
				 	    System.out.println(e.getCause());
				 	 } }
					
					
					
					
					//Click the ‘Deliver to’ drop-down, available to the top of the page and add another pin code and check the availability of the product delivery there.
					for(int i=0; i<=7;i++)
				      { try{
				    	  driver.findElement(By.xpath("//div[@class='_2LG8B7']")).click();
				  		  driver.findElement(By.xpath("//input[@class='_20PCkk']")).clear();
				  		  driver.findElement(By.xpath("//input[@class='_20PCkk']")).clear();
				  		  driver.findElement(By.xpath("//input[@class='_20PCkk']")).sendKeys("380001");
				  		  driver.findElement(By.xpath("//input[@class='_20PCkk']")).sendKeys(Keys.ENTER); 
				  		  //Print the message getting displayed for the availability/delivery of the product in the console for the changed Pincode.
						  System.out.println(driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='bzD9az'][1]")).getText());
						  System.out.println(driver.findElement(By.xpath("//img[@title='Flipkart']//following::div[@class='bzD9az'][2]")).getText());
				    	  break;
				 	       }
				 	 catch(Exception e){
				 	    System.out.println(e.getMessage());
				 	    System.out.println(e.getCause());
				 	 } }
					
		}

 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
