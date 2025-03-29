package com.kuldeepkumar290497.ex01_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Description("Verifying App.vwo wb application")
    @Test
    public void Test_AppVwo(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getSessionId());
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
