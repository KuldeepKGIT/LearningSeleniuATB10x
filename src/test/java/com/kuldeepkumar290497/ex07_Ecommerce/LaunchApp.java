package com.kuldeepkumar290497.ex07_Ecommerce;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LaunchApp extends TestCaseBoilerPlate {

    @Test
    @Description("Launching web application")
    public void LoginPage()
    {
       driver.manage().window().maximize();
       driver.get("https://demo.opencart.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
