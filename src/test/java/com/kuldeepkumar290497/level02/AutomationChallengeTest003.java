package com.kuldeepkumar290497.level02;

import com.kuldeepkumar290497.TCBoilerPlate;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationChallengeTest003 extends TCBoilerPlate {
    @Description("Verify the content of the Model ")
    @Test
    public void verifyContentModal(){
        driver.get("https://demoqa.com/modal-dialogs");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("showLargeModal")))).click();
        WebElement Content = driver.findElement(By.xpath("//div[@class='modal-body']/p"));
        String contentMSG = Content.getText();
        Assert.assertEquals(contentMSG,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");


    }
}
