package com.kuldeepkumar290497.level02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Level2WebTables {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void TestVerificationTable(){
       driver.get("https://demoqa.com/webtables");
       WebElement editButton = driver.findElement(By.xpath("//div[@class='action-buttons']/span[@id='edit-record-3']"));
       editButton.click();


    }
    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
