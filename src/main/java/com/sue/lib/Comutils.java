package com.sue.lib;

import java.io.File; 
import java.io.IOException; 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

import java.io.BufferedReader; 
import java.io.BufferedWriter;  
import java.io.FileReader; 
import java.io.FileWriter;  



public class Comutils 
{
	public static void snapshot(TakesScreenshot drivername, String filename)  {
		//this method will take screen shot ,require two parameters ,one is driver name, another is file name
		String currentPath = System.getProperty("user.dir");//get current work folder
		System.out.println(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try{
			//System.out.println("save snapshot path is:"+currentPath+"/"+filename);
			//FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
	        System.out.println("save snapshot path is:C:/Users/hyuan/javaworkspace1.8/App-java/screenshot/"+filename);
	        //FileUtils.copyFile(scrFile, new File("C:\\Users\\hyuan\\javaworkspace1.8\\App-java\\screenshot\\"+filename));
	        //绝对路径20170707
	        FileUtils.copyFile(scrFile, new File("screenshot/"+filename));
	        //换成相对路径20170707
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		}
		finally{
			System.out.println("screen shot finished");
		}
	}
	
	public static boolean logWriter(String logMessage, String fileName, Boolean isAppend) {
		//String filePath="C:\\Users\\hyuan\\javaworkspace1.8\\App-java\\log\\";
		//绝对路径20170707
		String filePath="log/";
		//相对路径20170707
		//String fileName = "20161130.txt";
	    String fullFileName = filePath+fileName;
	    String enter = System.getProperty("line.separator");//variable for creating new line
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	   isAppend = true;
	    try{
        File folder = new File(filePath);
        if(!folder.exists())
        {
         folder.mkdir();
        }
        File file = new File(fullFileName);
        if(!file.exists())
        {
         file.createNewFile();
        }
        BufferedReader in = new BufferedReader(new FileReader(file));
        String str = "";
        String strToal = "";
        while ((str = in.readLine()) != null)
        {
            strToal += (str + enter);
        }     
        strToal = strToal + (sdf.format(new Date()) + " " + logMessage + enter);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(strToal);
        out.close();
        }
	    catch (Exception e){
	    	e.printStackTrace();
	    	isAppend = false;
	    	return isAppend;
        }
	    return isAppend;
	 }
	
	public static boolean isContentAppeared(WebDriver driver,String content) {  
		     boolean status = false;  
		     try {  
		         driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
		         System.out.println(content + " is appeard!");  
		         status = true;  
		     } catch (NoSuchElementException e) {  
		         status = false;  
		         System.out.println("'" + content + "' doesn't exist!");  
		     }  
		     return status;  
		 } 
/*	public static boolean isWebElementExist(WebDriver driver, By selector){ 

        try { 
                driver.findElement(selector); 
                System.out.println("元素存在");
               return true; 
        } catch (NoSuchElementException e) { 
            System.out.println("元素不存在");
            return false; 
        } 
    }
*/  
	public static boolean isWebElementExist(WebDriver driver, String path){ 

        try { 
                driver.findElement(By.xpath(path)); 
                System.out.println("元素存在");
               return true; 
        } catch (NoSuchElementException e) { 
            System.out.println("元素不存在");
            return false; 
        } 
    }
		
}
