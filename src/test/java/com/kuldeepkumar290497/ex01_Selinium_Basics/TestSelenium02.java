package com.kuldeepkumar290497.ex01_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {
    @Description("Open the App.VWO and verfify the title")
    @Test
    public void Test_Selenium02(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        driver.quit();

        // Set up ChromeOptions
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // (Optional) For compatibility
        options.addArguments("--window-size=1920,1080"); // (Optional) Define screen size*/

    }
}
