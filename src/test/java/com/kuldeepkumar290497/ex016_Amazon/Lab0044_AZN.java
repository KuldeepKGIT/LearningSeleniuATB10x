package com.kuldeepkumar290497.ex016_Amazon;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Lab0044_AZN extends TestCaseBoilerPlate {
    @Test
    public void amazon_NonSponsored_article(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        WebElement searchInbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchInbox.sendKeys("herman miller office chair",Keys.ENTER);
        List<WebElement> non_Sponsored_Articles = driver.findElements(By.xpath("//div[@data-component-type='s-search-result' and not (.//*[contains(text(),'sponsored')])]"));
        non_Sponsored_Articles.get(0).click();
        for(WebElement Article: non_Sponsored_Articles){
            System.out.println("Article: "+Article);
        }



    }
}
