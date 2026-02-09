package com.kuldeepkumar290497.ex01_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium03 {
    @Description("Using Selenium first time")
    @Test
    public void Test(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getCurrentUrl());
        WebElement title = driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']"));
        String str = title.getText();
        System.out.println("Print title: "+ str);
        Assert.assertEquals(str, "google");
        driver.quit();
    }
}
