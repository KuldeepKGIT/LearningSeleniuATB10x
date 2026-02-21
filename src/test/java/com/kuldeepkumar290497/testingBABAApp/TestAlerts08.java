package com.kuldeepkumar290497.testingBABAApp;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAlerts08 extends TCBoilerPlate {
    @Test
    public void testAlerts(){
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        Actions action = new Actions(driver);
        WebElement AlertsWindowsFrame = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='mb-0']/button[@data-target='#alerts']")));
        action.moveToElement(AlertsWindowsFrame).click().build().perform();
        WebElement AlertsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='alerts']")));
        AlertsBtn.click();
        WebElement ClickMe1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myalert()']")));
        ClickMe1.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
