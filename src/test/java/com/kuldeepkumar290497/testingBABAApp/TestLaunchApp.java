package com.kuldeepkumar290497.testingBABAApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLaunchApp {
    @Test
    public void launchingApp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testingbaba.com/old/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@class='modal-title']/following-sibling :: button")));
        closeBtn.click();
        Thread.sleep(4000);
        driver.quit();
    }
}
