package com.sue.one;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class test1 {
	public static void main (String [] args) throws InterruptedException{
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

	}

}
