package com.guangyun;

/**
 * Created by 001117030057 on 2017/4/10.
 */


import com.tool.Logtool;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by 001117030057 on 2017/4/9.
 */
public class Testlog4j {
    public WebDriver driver;

    @Test
    public void testSearch() {
        Logtool.startTestCase("");
        driver.get("https://www.sogou.com/");
        Logtool.info("");
        driver.findElement(By.id("query")).sendKeys("");
        Logtool.info("");
        driver.findElement(By.id("stb")).click();
        Logtool.info("");
        String expectedTitle = "";
        Logtool.info("");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Logtool.endTestCase("");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        DOMConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\log4j.xml");
//        DOMConfigurator.configure("log4j.xml");
    }
}
