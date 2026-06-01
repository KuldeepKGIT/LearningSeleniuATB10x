package com.kuldeepkumar290497.level02;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadFileTest extends TCBoilerPlate {
    @Test
    public void downloadFileTest(){
        driver.get("http://demoqa.com/upload-download");
        WebElement downloadBtn = driver.findElement(By.xpath("//div/a[text()='Download']"));
        Actions action = new Actions(driver);
        action.moveToElement(downloadBtn).click().build().perform();
        String downloadPath = System.getProperty("user.home");
        File file = new File(downloadPath+"\\downloads");
        Assert.assertTrue(file.exists(),"file not found!");
    }
}
