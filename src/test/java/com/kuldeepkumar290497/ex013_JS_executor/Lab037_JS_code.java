package com.kuldeepkumar290497.ex013_JS_executor;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class Lab037_JS_code extends TestCaseBoilerPlate {
    @Test
    public void Test_JS_Executor(){
        driver.navigate().to("https://selectorshub.com/xpath-practice-page");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
//        js.executeScript("arguments[0].scrollIntoView(true);",div_to_scroll);

        js.executeScript("window.scrollBy(0,500);");

        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);
    }
}
