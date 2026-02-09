package com.kuldeepkumar290497.level01;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AppliToolsTest extends TestCaseBoilerPlate {

    @Test
    public void loginTest(){
            driver.manage().window().maximize();
            driver.get("https://demo.applitools.com/");
            driver.findElement(By.id("username")).sendKeys("Admin");
            driver.findElement(By.id("password")).sendKeys("Password@123");
            driver.findElement(By.xpath("//a[@id=\"log-in\"]")).sendKeys(Keys.ENTER);
        String user = driver.findElement(By.xpath("//div[@class='logged-user-name']")).getText();
        Assert.assertEquals(user,"Jack Gomez");
        List<WebElement> transactions = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr/td[5]/span[contains(text(),'USD')]"));
        Double spent = TransactionUtil.calculateTotalSpent(transactions);
        Double earned = TransactionUtil.calculateTotalEarned(transactions);
        Double total = TransactionUtil.calculateNetTotal(transactions);
        Assert.assertEquals(earned,1996.22);
        Assert.assertNotEquals(spent,0.0);
        Assert.assertNotEquals(earned,0.0);
    }


}
