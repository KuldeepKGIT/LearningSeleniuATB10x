package com.kuldeepkumar290497.ex06_Input_Select_Alerts_Radio_Checkbox;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium027_JSalerts {
    @Test
    public void test_alert(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

//        WebElement element_1 = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
//        element_1.click();
//        WebElement element_2 = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
//        element_2.click();
        WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        elementPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert_1 = driver.switchTo().alert();
        alert_1.sendKeys("Kuldeep");
        alert_1.accept();
//        alert_1.dismiss();
        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You successfully clicked an alert");
//        Assert.assertEquals(result, "You clicked: Ok");
//        Assert.assertEquals(result, "You clicked: Cancel");
        Assert.assertEquals(result, "You entered: Kuldeep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
