package com.kuldeepkumar290497.ex02_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium017_project1 {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void Test_Negative_VWO_login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
//        <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        WebElement InputEmailBox = driver.findElement(By.id("login-username"));
        InputEmailBox.sendKeys("admin@admin.com");
        WebElement PasswordBox = driver.findElement(By.id("login-password"));
        PasswordBox.sendKeys("admin");
        WebElement ButtonBox = driver.findElement(By.id("js-login-btn"));
        ButtonBox.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");


    }
}
