package com.guangyun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by 001117030057 on 2017/4/27.
 */
public class TestKdzs {
    public class TestScreen {
        public WebDriver driver;

        private String baseUrl;

        @BeforeClass
        public void beforeClass() {
            baseUrl = "http://baidu.com";
            System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
            driver.findElement(By.xpath(".//*[@id='taobaoNick']")).sendKeys("梦曼欣");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @AfterClass
        public void tearDown() {
            driver.close();
        }

    }
}
