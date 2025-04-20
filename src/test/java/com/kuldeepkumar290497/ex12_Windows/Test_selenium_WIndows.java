package com.kuldeepkumar290497.ex12_Windows;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class Test_selenium_WIndows extends TestCaseBoilerPlate {
    @Test
    public void Test_windows_switch(){
        String URL= "https://the-internet.herokuapp.com/windows";
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window handles: "+ windowHandles);

        for(String Handle : windowHandles){
            driver.switchTo().window(Handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test case is passed");
            }
            driver.switchTo().window(parentWindow);
        }



    }
}
