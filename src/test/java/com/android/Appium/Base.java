package com.android.Appium;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public Random rand = new Random();
	UiAutomator2Options options =new UiAutomator2Options();
	
	@BeforeTest
	public void configureAppium() throws MalformedURLException {
		//run appium server
	    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HOME\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
	   
	    service.start();
	    
		//create capabilities
		
		options.setDeviceName("emulator-5554");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\calculator.apk");
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

		/*//create opject for Android
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));*/
	}
	
	@BeforeMethod
	  //create opject for Android
	public void MyBeforeMethod() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
	}
	
    @Test (priority =1, description="Multiplay number 7*9 the assert the result is 63", enabled= false)
    public void MultiplayTowNumber() throws MalformedURLException {
    	
  		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
  		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
  		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
  		
  		String ExpectedResult ="63";
  		WebElement Results = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
  		String ActualResult = Results.getText();
  		
  		Assert.assertEquals(ActualResult, ExpectedResult);
}
    @Test(priority =2, description="Click on All Items", enabled =false )
    public void ClickonAllItems() throws MalformedURLException {
    	
    	List <WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));	
    	for(int i=0 ; i< AllButtons.size() ; i++ ) {
    		AllButtons.get(i).click();
    	}	  		
    } 
    
    @Test(priority =3, description="Click Only On All Numbers", enabled =false )
    public void ClickOnlyOnNumbers() throws MalformedURLException {
    	
    	List <WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));	
    	for(int i=0 ; i< AllButtons.size() ; i++ ) {
    		if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit")) {
    			AllButtons.get(i).click();
			}  	
    	}
    }
    
    @Test(priority =4, description="Click Only On Even Numbers Or Odd Numbers", enabled =false )
    public void ClickOnlyOnEvenNumbers() throws MalformedURLException {
    	
    	List <WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));	
    	for(int i=0 ; i< AllButtons.size() ; i++ ) {
    		if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit")) {
    			int Thenumber = Integer.parseInt(AllButtons.get(i).getDomAttribute("content-desc"));
    			
    			if(Thenumber%2==0) {
    				AllButtons.get(i).click();
    				//Click Only On Odd Numbers
    				/*if(Thenumber%2==1) {
        				AllButtons.get(i).click();*/
    			}
    			
			}  	
    	}
    }
    
    @Test(priority =5, description="Multiply Tow Random Numbers", enabled =true )
    public void MultiplyTowRandomNumbers() throws MalformedURLException, InterruptedException {
    	//Random number 0-9
    	String FirstNumber =Integer.toString(rand.nextInt(10));
    	String SecondNumber = Integer.toString(rand.nextInt(10));
    	  
    	List <WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));	
    	Thread.sleep(3000);
    	for(int i=0 ; i< AllButtons.size() ; i++ ) {
    		// The Bad code 
//    		if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit") && AllButtons.get(i).getDomAttribute("resource-id").contains(FirstNumber)|| AllButtons.get(i).getDomAttribute("resource-id").contains(SecondNumber)) {
//    			AllButtons.get(i).click();
//    			driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
//    		}
    		
    		// The good code
    		/*if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit") && AllButtons.get(i).getDomAttribute("resource-id").contains(FirstNumber)) {
    			AllButtons.get(i).click();
    			driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();	
    		}	
    		if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit") && AllButtons.get(i).getDomAttribute("resource-id").contains(SecondNumber)) {
    			AllButtons.get(i).click();
    		}*/
    		
    	   // Very good code
    		if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit_"+FirstNumber)){
    			AllButtons.get(i).click();	
    			driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
    		}
    	  }
    	for(int i=0 ; i< AllButtons.size() ; i++ ) {
			if (AllButtons.get(i).getDomAttribute("resource-id").contains("digit_"+SecondNumber)) {
    			AllButtons.get(i).click();
    		}
		  }
        }
     }
      			

