package com.kuldeepkumar290497.ex02_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium09 {
    @Description("Open the Url")
    @Test
    public void Test_selenium04()throws Exception{
        EdgeDriver driver= new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        if ( driver.getPageSource().contains("CURA Healthcare ")){
            Assert.assertTrue(true);
        }
        else {
            //Assert.assertTrue(false);
throw new Exception("Element is not there in the page source");
        }
        driver.quit();
    }
}
