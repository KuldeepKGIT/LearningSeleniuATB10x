package com.kuldeepkumar290497.testingBABAApp;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestElementsDownload06 extends TCBoilerPlate {
    @Test
    public void testDownload(){
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        WebElement elements = driver.findElement(By.xpath("//h2[@class='mb-0']/button[@data-target='#elements']"));
        elements.click();
        WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'upload')]")));
        uploadBtn.click();
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='File1']"));
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        chooseFile.sendKeys(workingDir+"/src/test/java/com/kuldeepkumar290497/testingBABAApp/TestData.txt");
    }
}
