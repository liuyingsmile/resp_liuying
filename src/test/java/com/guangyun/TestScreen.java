package com.guangyun;

import org.apache.commons.io.FileUtils;
import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by 001117030057 on 2017/4/27.
 */
public class TestScreen{
    public WebDriver driver;
    private String baseUrl;
    @BeforeClass
    public void beforeClass(){
        java.lang.String baseUrl = "http://baidu.com";
        System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='kw']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    @Test
    public void testScreen() throws InterruptedException, IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        FileUtils.copyFile(screenshot, new File("d:\\sogouHomePage_actual.jpg"));
        //生成了两个文件对象，一个是期望的图片，一个是实际测试过程中产生的图片
        File fileInput = new File("d:\\sogouHomePage_expected.jpg");
        File fileOutPut = new File("d:\\sogouHomePage_actual.jpg");
        /*
         以下部分为两个文件进行像素比对的算法实现，获取文件的像素个数大小，然后使用循环的方式将两张图片的
         所有项目进行一一对比，如有任何一个像素不相同，则退出循环，将matchFlag变量的值设定为false，
         最后使用断言语句判断matchFlag是否为true。如果为true表示两张图片完全一致，如果为false
         表示两张图片并不是完全匹配
         */
        BufferedImage bufileInput = ImageIO.read(fileInput);

        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();

        int sizefileInput = dafileInput.getSize();

        BufferedImage bufileOutPut = ImageIO.read(fileOutPut);

        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();

        int sizefileOutPut = dafileOutPut.getSize();

        Boolean matchFlag = true;

        if(sizefileInput == sizefileOutPut){
            for(int j = 0; j<sizefileInput; j ++){
                if(dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
                    matchFlag =  false;
                    break;
                }
            }
        }
        else
            matchFlag = false;

       Assert.assertTrue(matchFlag);
    }
}






















