package com.guangyun;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by 001117030057 on 2017/4/16.
 */
public class TestCompareImages {
    public WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void testImageComparison()throws IOException,InterruptedException{
        driver.navigate().to("http://www.sogou.com");
        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        FileUtils.copyFile(screenshot,new File("d:\\sogou_actual.jpg"));
        File fileInput =new File("d:\\sogou_actual_expected.jpg");
        File fileOutput =new File("d:\\sogou_actual.jpg");
        BufferedImage bufileInput = ImageIO.read(fileInput);
        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
        int sizefileInput =dafileInput.getSize();
        BufferedImage bufileOutput=ImageIO.read(fileOutput);
        DataBuffer bufileOutPut = bufileOutput.getData().getDataBuffer();
    }


}
