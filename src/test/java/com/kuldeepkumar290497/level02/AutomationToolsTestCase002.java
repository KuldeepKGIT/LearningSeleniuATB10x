package com.kuldeepkumar290497.level02;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationToolsTestCase002 extends TCBoilerPlate {
    @Test
    public void CheckBoxTest(){
        driver.get("https://demoqa.com/checkbox");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement checkBox = driver.findElement(By.xpath("//span[@role='checkbox' and @aria-label='Select Home']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        WebElement result = driver.findElement(By.xpath("//div[@id='result']"));
        Assert.assertTrue(result.isDisplayed());
    }

}
