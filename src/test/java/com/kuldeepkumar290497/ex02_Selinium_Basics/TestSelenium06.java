package com.kuldeepkumar290497.ex02_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium06 {
    @Description("Get the URL")
    @Test
    public void Test_Selenium02(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
