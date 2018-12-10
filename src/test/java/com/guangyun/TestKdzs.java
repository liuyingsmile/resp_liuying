package com.guangyun;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 001117030057 on 2017/4/27.
 */

public class TestKdzs {
    public WebDriver driver;

    private String baseUrl;

    @Test
    public void beforeClass() {
        //登录kdzs后台
      
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='login']/div[2]/form/div[1]/div/div[1]/input")).sendKeys("kdzs");
        driver.findElement(By.xpath(".//*[@id='login']/div[2]/form/div[2]/div/div/input")).sendKeys("mfiDYg8kHkvZFJ3E");
        driver.findElement(By.xpath(".//*[@id='login']/div[2]/form/div[3]/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //登录kdzs
        driver.switchTo().frame(driver.findElement(By.className("content-iframe")));
        driver.findElement(By.id("taobaoNick")).sendKeys("梦曼欣");
        driver.findElement(By.id("query")).click();
        driver.findElement(By.linkText("旺旺：梦曼欣")).click();
        //进入实用工具
        driver.findElement(By.xpath(".//*[@id='app-head']/div/ul/li[7]/a/span")).click();
        //实用工具--批量导入excel
        driver.findElement(By.xpath(".//*[@id='customContent']/div[2]/dl/dt/a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='handerUpTradesFile']")).click();
        //处理未安装打印控件
        driver.findElement(By.xpath(".//*[@id='login']/div[2]/form/div[1]/div/div[1]/input")).sendKeys("kdzs");
//        driver.switchTo().alert().accept();
        //处理提示窗口



    }

}
