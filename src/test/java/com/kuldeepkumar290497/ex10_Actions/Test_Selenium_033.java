package com.kuldeepkumar290497.ex10_Actions;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.checkVisibility;
import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class Test_Selenium_033 extends TestCaseBoilerPlate {
    @Test
    public void Test_actions_02(){
        String URL = "https://www.makemytrip.com";
        driver.get(URL);
        driver.manage().window().maximize();

        checkVisibility(driver, By.xpath("//span[@data-cy=\"closeModal\"]"));

        WebElement modal = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
        modal.click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        waitJVM(3000);

        List<WebElement> ListOfCities = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
        for(WebElement city : ListOfCities){
            if (city.getText().contains("Chandigarh")){
                city.click();
            }
        }





    }
}
