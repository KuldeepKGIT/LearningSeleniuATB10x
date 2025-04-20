package com.kuldeepkumar290497.ex10_Actions;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Test_Selenium_035 extends TestCaseBoilerPlate {
    @Test
    public void  test_pageUpDown(){
        driver.get("https://thetestingacademy.com/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).build().perform();
    }
}
