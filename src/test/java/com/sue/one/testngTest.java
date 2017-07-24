package com.sue.one;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

//import java.lang.reflect.Proxy;

public class testngTest {
  @Test
  //public void f() {
  //  System.out.println("this is TestNG test case");
  //}
  
  public void test1()throws InterruptedException {
			File file = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		    
		    WebDriver driver = new ChromeDriver();
		    driver.get("http://www.baidu.com/");
			     
		    driver.manage().window().maximize();
		    
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	   
		    com.sue.lib.Comutils.snapshot((TakesScreenshot)driver,"open_baidu.png");
		    
			
			WebElement txtbox = driver.findElement(By.name("wd"));
			txtbox.sendKeys("Helloworld");
			Thread.sleep(3000);
			com.sue.lib.Comutils.snapshot((TakesScreenshot)driver,"input_keyWord.png");
	        
	        WebElement btn = driver.findElement(By.id("su"));
			btn.click();
			       
			driver.quit();
			
			com.sue.lib.Comutils.logWriter("timeisjjja", "20170705.txt", true);
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("this is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("this is after class");
  }

}
