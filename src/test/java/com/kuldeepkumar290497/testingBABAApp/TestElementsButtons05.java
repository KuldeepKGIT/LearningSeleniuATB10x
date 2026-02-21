package com.kuldeepkumar290497.testingBABAApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TestElementsButtons05 {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TestButtons() {
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        WebElement elements = driver.findElement(By.xpath("//h2[@class='mb-0']/button[@data-target='#elements']"));
        elements.click();
        WebElement buttons = driver.findElement(By.xpath("//a[text()='buttons']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttons));
        buttons.click();
        WebElement clickDouble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Double')]")));
        WebElement rightClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Right')]")));
        WebElement dynamicClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Click') and @onclick='clicktext()']")));
        Actions action = new Actions(driver);
        action.doubleClick(clickDouble).build().perform();
        action.contextClick(rightClick).build().perform();
        action.click(dynamicClick).build().perform();
        String msgDoubleClick = driver.findElement(By.xpath("//div[@class='btn-content']/child::p[@id='double-content']")).getText();
        String msgRightClick = driver.findElement(By.xpath("//div[@class='btn-content']/child::p[@id='right-content']")).getText();
        String msgDynamicClick = driver.findElement(By.xpath("//div[@class='btn-content']/child::p[@id='click-content']")).getText();
        Assert.assertEquals(msgDoubleClick, "you have done a double click");
        Assert.assertEquals(msgRightClick, "you have done a right click");
        Assert.assertEquals(msgDynamicClick, "you have done a dynamic click");

    }
    @AfterTest
    public void tearDown() throws InterruptedException{
        Thread.sleep(10000);
        driver.quit();
    }
}
