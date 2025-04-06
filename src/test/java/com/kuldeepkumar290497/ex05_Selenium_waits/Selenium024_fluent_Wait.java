package com.kuldeepkumar290497.ex05_Selenium_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Selenium024_fluent_Wait {
    @Description("Verifying App.VWO")
    @Test
    public void test_AppVWO_FluentWait(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start_maximized");

        EdgeDriver driver = new EdgeDriver();
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInput = driver.findElement(By.id("login-username"));
        emailInput.sendKeys("admin@admin.com");
        WebElement passwordInput = driver.findElement(By.id("login-password"));
        passwordInput.sendKeys("password@321");
        WebElement SignIn = driver.findElement(By.id("js-login-btn"));
        SignIn.click();

        // Fluent Wait

        FluentWait<EdgeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);


        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("notification-box-description"));
            }
        });


        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        driver.quit();
    }
}
