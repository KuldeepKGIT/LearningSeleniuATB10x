package com.kuldeepkumar290497.ex08_SVG_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.checkVisibility;
import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class

Lab029_SVG_Map {
    EdgeDriver driver;

    @BeforeTest

    public void StartBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Tripura is present in the map and click to zoom it")
    @Test
    public void test_IndiaMap_svg(){
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();
        List<WebElement> States = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement state : States){
            System.out.println(state.getDomAttribute("aria-label"));
            if (state.getDomAttribute("aria-label").contains("Tripura")){
                state.click();
            }
        }
//        Alert alert_1 = driver.switchTo().alert();
//        alert_1.accept();


    }

    @AfterTest
    public void closeBrowser(){
        waitJVM(10000);
        driver.quit();

    }
}
