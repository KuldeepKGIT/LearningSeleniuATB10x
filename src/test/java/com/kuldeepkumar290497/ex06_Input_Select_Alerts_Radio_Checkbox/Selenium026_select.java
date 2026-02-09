package com.kuldeepkumar290497.ex06_Input_Select_Alerts_Radio_Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium026_select {
    @Test
            public void Test_Select(){

        EdgeDriver driver = new EdgeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement Element = driver.findElement(By.id("dropdown"));
        Select select_dropDown = new Select(Element);
//        select_dropDown.selectByIndex(0);
//        select_dropDown.selectByValue("2");
        select_dropDown.selectByVisibleText("Option 1");


        // Explicit wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Element));


       Assert.assertEquals(Element.isDisplayed(),true);


driver.quit();
    }
}
