package com.kuldeepkumar290497.ex014_RelativeLocators;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab040_RL_p2 extends TestCaseBoilerPlate {
    @Test
    public void  Test_RL_p2(){
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        driver.switchTo().frame("result");
        WebElement submit_btn = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));
        submit_btn.click();

        WebElement userName_element = driver.findElement(By.xpath("//input[@id=\"username\"]"));
        WebElement error_msg = driver.findElement(with(By.tagName("small")).below(userName_element));
        String error_message= error_msg.getText();
        Assert.assertEquals(error_message,"Username must be at least 3 characters");
    }
}
