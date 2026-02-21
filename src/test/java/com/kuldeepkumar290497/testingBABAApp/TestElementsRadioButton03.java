package com.kuldeepkumar290497.testingBABAApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestElementsRadioButton03 {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TestRadioButton(){
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        WebElement elements = driver.findElement(By.xpath("//h2[@class='mb-0']/button[@data-target='#elements']"));
        elements.click();
        WebElement radioButton = driver.findElement(By.xpath("//a[contains(text(),'radio')]"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();
        WebElement yesButton = driver.findElement(By.xpath("//div[@class='form-check-inline']/descendant::input[@id='yes']"));
                wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
        WebElement msg = driver.findElement(By.xpath("//div[@class='form-check-inline']/following-sibling::p[@id='radio-content']"));
        String result = msg.getText();
        Assert.assertTrue(true,result);
    }
    @AfterTest
    public void tearDown() throws InterruptedException{
        Thread.sleep(10000);
        driver.quit();
    }
}
