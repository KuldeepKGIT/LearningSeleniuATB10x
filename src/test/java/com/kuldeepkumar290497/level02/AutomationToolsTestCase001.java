package com.kuldeepkumar290497.level02;

import com.kuldeepkumar290497.TCBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AutomationToolsTestCase001 extends TCBoilerPlate {
    @Description("First test")
    @Test
    public void textBoxTest(){
        driver.get("https://demoqa.com/text-box");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("Kuldeep Kumar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("kuldeep123@gmail.com");
        WebElement inputAddress = driver.findElement(By.id("currentAddress"));
        wait.until(ExpectedConditions.visibilityOf(inputAddress)).sendKeys("ABC, ghaziabad");
        WebElement currentAddress = driver.findElement(By.id("permanentAddress"));
        currentAddress.sendKeys("ABC, ghaziabad");
        WebElement submitBtn = driver.findElement(By.id("submit"));
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).sendKeys(Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",submitBtn);

        List<String> expectedValues = Arrays.asList("Kuldeep Kumar", "kuldeep123@gmail.com","ABC, ghaziabad", "ABC, ghaziabad");
        List<WebElement> inputFields = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']/p"));

        int i=0;
        for(WebElement input : inputFields){

            Assert.assertEquals(input.getText(),expectedValues.get(i));
            i++;
        }
    }

}
