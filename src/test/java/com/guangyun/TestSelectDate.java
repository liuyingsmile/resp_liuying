package com.guangyun;

import org.openqa.selenium.By;
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
        driver.navigate().to("http://jqueryui.com/resources/demos/datepicker/other-months.html");
        WebElement dataInputBox=driver.findElement(By.className("hasDatepicker"));
        dataInputBox.sendKeys("12/4/2017");
        Thread.sleep(3000);

    }
////    @AfterClass
////    public void afterMethod(){
////        driver.quit();
//    }
}
