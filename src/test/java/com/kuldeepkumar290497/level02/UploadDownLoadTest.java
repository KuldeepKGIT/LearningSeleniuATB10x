package com.kuldeepkumar290497.level02;

import com.kuldeepkumar290497.TCBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadDownLoadTest extends TCBoilerPlate {
     @Test
    public void uploadDownloadTest(){
         driver.get("https://demoqa.com/upload-download");
         WebElement chooseFile = driver.findElement(By.xpath("//input[@label='Select a File']"));
         chooseFile.sendKeys("C:\\Users\\asus\\Downloads\\sampleFile.jpeg");
         WebElement result = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));
         Assert.assertTrue(result.isDisplayed());
         String path = System.getProperty("user.dir");
         System.out.println(path);


     }
}
