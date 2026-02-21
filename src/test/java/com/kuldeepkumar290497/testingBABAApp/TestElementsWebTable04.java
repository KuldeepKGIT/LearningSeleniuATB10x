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

public class TestElementsWebTable04 {
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
        WebElement webTable = driver.findElement(By.xpath("//a[contains(text(),'web')]"));
        wait.until(ExpectedConditions.elementToBeClickable(webTable));
        webTable.click();
        driver.switchTo().frame(1);
        WebElement inputName = driver.findElement(By.xpath("//label[contains(text(),'Name:')]/following-sibling::input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        inputName.sendKeys("Kuldeep Kumar");
        WebElement inputEmail = driver.findElement(By.xpath("//label[contains(text(),'Email:')]/following-sibling::input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.sendKeys("KuldeepKumar@gmail.com");
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
        saveBtn.click();
        String name = driver.findElement(By.xpath("//table[@class='table table-bordered data-table']/child::tbody/child::tr/td[1]")).getText();
        Assert.assertEquals(name,"Kuldeep Kumar");


    }
    @AfterTest
    public void tearDown() throws InterruptedException{
        Thread.sleep(10000);
        driver.quit();
    }
}
