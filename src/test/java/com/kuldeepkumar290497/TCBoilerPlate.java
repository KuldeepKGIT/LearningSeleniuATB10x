package com.kuldeepkumar290497;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class TCBoilerPlate {
    public WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
 driver = new ChromeDriver();
 driver.manage().window().maximize();

    }

    @AfterTest
    public void CloseBrowser(){
        waitJVM(15000);
        driver.quit();

    }
}
