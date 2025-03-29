package com.kuldeepkumar290497.ex02_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium07 {
    @Description("Get the URL")
    @Test
    public void Test_Selenium03() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
