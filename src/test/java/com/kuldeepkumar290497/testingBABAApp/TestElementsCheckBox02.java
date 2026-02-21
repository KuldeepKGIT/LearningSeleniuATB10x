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

public class TestElementsCheckBox02 {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TestCheckBox(){
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        WebElement elements = driver.findElement(By.xpath("//h2[@class='mb-0']/button[@data-target='#elements']"));
        elements.click();
        WebElement checkBox = driver.findElement(By.xpath("//a[contains(text(),'check box')]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        driver.switchTo().frame(0);
        WebElement mobileBox = driver.findElement(By.xpath("//label[text()='Mobile:']/following-sibling::input[@id='myCheck']"));
        wait.until(ExpectedConditions.elementToBeClickable(mobileBox));
        mobileBox.click();
//        WebElement laptopBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Laptop')]/preceding-sibling::input[@type='checkbox']")));
//        laptopBox.click();
//        WebElement desktopBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Desktop')]/preceding-sibling::input[@type='checkbox']")));
//        desktopBox.click();
        WebElement msg = driver.findElement(By.xpath("//h6[contains(text(),'Mobile')]"));
        String result = msg.getText();
        Assert.assertEquals(result,"You are selected Mobile");
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
