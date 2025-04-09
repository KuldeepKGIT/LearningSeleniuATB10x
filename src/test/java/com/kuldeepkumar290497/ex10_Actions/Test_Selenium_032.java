package com.kuldeepkumar290497.ex10_Actions;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test_Selenium_032 extends TestCaseBoilerPlate {
    @Test
    public void Test_actionClass(){
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement FirstName = driver.findElement(By.name("firstname")); // Locating Element

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(FirstName,"hello kuldeep!").keyUp(Keys.SHIFT).build().perform();

    }
}
