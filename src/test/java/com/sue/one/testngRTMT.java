//package com.example.tests;
package com.sue.one;

//import java.util.regex.Pattern;
//import java.util.*;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class testngRTMT{
  private WebDriver driver;
  //private String baseUrl;
 // private boolean acceptNextAlert = true;
  //private String content;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
    System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();  
  }

  @Test
  public void RTMT() throws Exception {
    driver.get("http://211.151.105.107/vwg-rtm-portal/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("tester1");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.linkText("实时监控")).click();
    
    driver.switchTo().frame("iframe").findElement(By.linkText("列表模式")).click();
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
    driver.findElement(By.linkText("查看详情")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("车辆概况")).click();
    //com.sue.lib.Comutils.isContentAppeared((WebDriver)driver,"CarNum lastReportTime"); //确认时间存在
    Thread.sleep(3000);//线程休眠3秒
    
    com.sue.lib.Comutils.isWebElementExist((WebDriver)driver,"//html/body/div[3]/label[.='2017-06-12 14:09:50']"); //确认时间存在  
    WebElement t = driver.findElement(By.xpath("//html/body/div[3]/label[.='2017-06-12 14:09:50']"));
    System.out.println(t.getText().toString());  //打印时间
    String testtext = null;              
    testtext= driver.findElement(By.xpath("//html/body/div[4]/div[2]/div[1]/span")).getText().toString();
    System.out.println(testtext);
    com.sue.lib.Comutils.isWebElementExist((WebDriver)driver,"//html/body/div[4]/div[2]/div[1]/span");//确认“车辆概况数据”    
    WebElement v = driver.findElement(By.xpath("//html/body/div[4]/div[2]/div[1]/span"));//“车辆概况数据”
    System.out.println(v.getText().toString());  //打印出文本框里的值
  
    WebElement v1 = driver.findElement(By.xpath(".//*[@id='carInfo']/li[1]"));
    System.out.println(v1.getText());
    com.sue.lib.Comutils.logWriter(v1.getText(), "20170711.txt", true);
    
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[2]/span[1]")).getText();//id="vehNumber"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[3]/span[1]")).getText();//id="mileage"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[4]/span[1]")).getText();//id="soc"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[5]/span[1]")).getText();//id="vehStatus"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[6]/span[1]")).getText();//id="speed"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[7]/span[1]")).getText();//id="driveMotorSpeed"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[8]/span[1]")).getText();//id="faultLevel"
    driver.findElement(By.xpath(".//*[@id='carInfo']/li[9]/span[1]")).getText();//id="location"
    
    driver.findElement(By.linkText("车辆监控")).click();
    driver.findElement(By.linkText("整车信息")).click();
    driver.findElement(By.linkText("极值信息")).click();
    driver.findElement(By.linkText("驱动电机数据")).click();
    driver.findElement(By.linkText("报警数据")).click();
    driver.findElement(By.linkText("车辆位置数据")).click();
    driver.findElement(By.linkText("车辆追踪")).click();
    driver.findElement(By.linkText("轨迹回放")).click();
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[1]/span[2]")).click();
     
    Thread.sleep(3000);//线程休眠3秒
	com.sue.lib.Comutils.snapshot((TakesScreenshot)driver,"Acount1.png");
    driver.findElement(By.linkText("退出")).click();
	
	//com.sue.lib.Comutils.logWriter(v1.getText(), "20170711.txt", true);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  /*private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
*/
 /* private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}
