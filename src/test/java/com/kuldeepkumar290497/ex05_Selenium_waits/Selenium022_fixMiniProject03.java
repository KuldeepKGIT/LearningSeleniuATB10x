package com.kuldeepkumar290497.ex05_Selenium_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium022_fixMiniProject03 {
    @Description("Verify that with valid email, pass, appointment page is loaded ")
    @Test
    public void Test_katalon_Login(){
        WebDriver driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app.vwo.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
//        <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        WebElement InputEmailBox = driver.findElement(By.id("login-username"));
        InputEmailBox.sendKeys("admin@admin.com");
        WebElement PasswordBox = driver.findElement(By.id("login-password"));
        PasswordBox.sendKeys("admin");
        WebElement ButtonBox = driver.findElement(By.id("js-login-btn"));
        ButtonBox.click();
        //Explicit wait- Applying
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");


    }
}
