package com.guangyun;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 001117030057 on 2017/4/23.
 */
public class TestSelectDate {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        //设定链接谷歌浏览器驱动程序所在的磁盘位置，并添加为系统属性值
        System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void testSelectDate() throws Exception{
        //driver.navigate().to("http://www.sucaijiayuan.com/api/demo.php?url=/demo/20141108-1/");
        driver.navigate().to("https://kyfw.12306.cn/otn/leftTicket/init");
//        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;
//        //remove readonly attribute
//        removeAttribute.executeScript("var setDate=document.getElementById(\"txtBeginDate\");setDate.removeAttribute('readonly');") ;
////        WebElement dataInputBox=driver.findElement(By.className("hasDatepicker"));
////        dataInputBox.sendKeys("12/4/2017");
////        Thread.sleep(3000);
//        driver.findElement(By.id("txtBeginDate")).sendKeys("12/4/2017");
//        Thread.sleep(3000);
//        System.out.println(driver.findElement(By.id("txtBeginDate")).getAttribute("value"));

//        driver.switchTo().frame("iframe");
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;
     //原生js，移除属性
        //js = "$('input[id=txtBeginDate]').removeAttr('readonly')"  # 2.jQuery，移除属性
        //js = "$('input[id=txtBeginDate]').attr('readonly',false)"  # 3.jQuery，设置为false
        // js = "$('input[id=txtBeginDate]').attr('readonly','')"  # 4.jQuery，设置为空（同3）
      //  removeAttribute.executeScript("document.getElementsByName(\"leftTicketDTO.train_date\").removeAttribute('readonly')");
        //选择建立时间--清除日期控件是readonly属性
//remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementsByName(\"leftTicketDTO.train_date\")[0];setDate.removeAttribute('readonly');") ;
        driver.findElement(By.name("leftTicketDTO.train_date")).sendKeys("12/4/2017");
       //  driver.findElement(By.name("leftTicketDTO.train_date")).sendKeys("12/4/2017");
         Thread.sleep(3000);



    }
////    @AfterClass
////    public void afterMethod(){
////        driver.quit();
//    }
}
