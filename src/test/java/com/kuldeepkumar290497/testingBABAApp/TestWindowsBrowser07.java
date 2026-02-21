package com.kuldeepkumar290497.testingBABAApp;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestWindowsBrowser07 extends TCBoilerPlate {
    @Test
    public void testWindowsBrowser() throws InterruptedException {
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        Actions action = new Actions(driver);
        WebElement AlertsWindowsFrame = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='mb-0']/button[@data-target='#alerts']")));
        action.moveToElement(AlertsWindowsFrame).click().build().perform();
        WebElement WindowsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'browser')]")));
        WindowsBtn.click();
        WebElement newTabBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'New') and @target='_blank']")));
        newTabBtn.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows){
            if(!window.equals(parentWindow)){
driver.switchTo().window(window);
break;
            }
        }
        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        String CurrentUrl= driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl,"https://www.testingbaba.com/old/newdemo.html");
    }
}
