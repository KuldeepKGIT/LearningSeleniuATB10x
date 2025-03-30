package com.kuldeepkumar290497.ex04_Xpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MiniProject_03_selenium_20 {
    @Description("Verify that with valid email, pass, appointment page is loaded ")
    @Test
    public void Test_katalon_Login(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement Make_Apointment_BTN = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        Make_Apointment_BTN.click();
        List<WebElement> user_name_field = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        user_name_field.get(1).sendKeys("John Doe");
        List<WebElement> password_input_box = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password_input_box.get(1).sendKeys("ThisIsNotAPassword");

        WebElement login_input_box = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_input_box.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.quit();
    }
}
