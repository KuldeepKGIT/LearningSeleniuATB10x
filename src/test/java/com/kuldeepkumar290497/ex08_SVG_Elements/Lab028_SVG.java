package com.kuldeepkumar290497.ex08_SVG_Elements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.checkVisibility;
import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class Lab028_SVG {
    EdgeDriver driver;

    @BeforeTest

    public void StartBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify that the on search with svg icon results are visible.")
    @Test
    public void test_Flipkart_Search_SVG_Icon(){
        String URL = "https://www.flipkart.com/search";
    driver.get(URL);

        // Step 1 - Enter the "macnmini" in the inputbox.

        driver.findElement(By.name("q")).sendKeys("macmini");

        // Step 2 - Click on the svg element.
List<WebElement> svg_Elements = driver.findElements(By.xpath("//*[local-name()='svg']"));
svg_Elements.get(0).click();

checkVisibility(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

List<WebElement> Title_results = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
for(WebElement Title : Title_results){
    System.out.println(Title.getText());
}




    }

    @AfterTest
    public void closeBrowser(){
        waitJVM(10);
        driver.quit();

    }
}
