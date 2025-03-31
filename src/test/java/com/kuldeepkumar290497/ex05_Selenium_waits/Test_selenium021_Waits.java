package com.kuldeepkumar290497.ex05_Selenium_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_selenium021_Waits {
    @Description("Verifying App.VWO login")
    @Test
    public void Test_AppVWO_Login(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        edgeDriver.get("https://app.vwo.com");
        System.out.println(edgeDriver.getTitle());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        edgeDriver.quit();
    }
}
