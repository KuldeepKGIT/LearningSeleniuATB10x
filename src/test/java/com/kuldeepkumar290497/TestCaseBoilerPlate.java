package com.kuldeepkumar290497;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class TestCaseBoilerPlate {
    public WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximize");
         driver = new EdgeDriver(options);
//        driver = new ChromeDriver();

    }

    @AfterTest
    public void CloseBrowser(){
        waitJVM(15000);
        driver.quit();

    }
}
