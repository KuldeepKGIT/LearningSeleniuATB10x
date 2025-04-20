package com.kuldeepkumar290497.ex014_RelativeLocators;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab039_RL_p1 extends TestCaseBoilerPlate {
    @Test
    public void Test_RL (){
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement Span_Element = driver.findElement(By.xpath("//span[contains(text(),'Experience')]"));
        driver.findElement(with(By.id("exp-1")).toRightOf(Span_Element)).click();
    }

}
