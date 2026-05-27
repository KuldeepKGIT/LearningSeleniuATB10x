package com.kuldeepkumar290497.level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutomationChallengeTest {
    public WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @Test
    public void calculateTotalAmountTest(){
        driver.get("https://demo.applitools.com");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(inputUsername)).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOf(inputPassword)).sendKeys("Password@123");
        WebElement LoginBtn = driver.findElement(By.xpath("//div[@class='buttons-w']/a[contains(text(),'Sign')]"));
        wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.applitools.com/app.html");
        List<WebElement> transactions = driver.findElements(By.xpath("//table/tbody/tr/td[@class='text-right bolder nowrap']"));
        double spent = 0.0;
        double earned = 0.0;
        for(WebElement transaction :transactions){
            System.out.println(transaction.getText());
            String amount = transaction.getText().replace("USD","").replace(",","").trim();
            if(amount.contains("-")){
                double value = Double.parseDouble(amount.replace("-","").trim());
                spent +=value;
            }
            else {
                double value = Double.parseDouble(amount.replace("+","").trim());
                earned +=value;
            }
        }
        double total = earned - spent;
        Assert.assertEquals(total,1996.22,0.1);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
