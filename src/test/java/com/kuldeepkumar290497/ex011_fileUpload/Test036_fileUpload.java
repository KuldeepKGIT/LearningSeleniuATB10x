package com.kuldeepkumar290497.ex011_fileUpload;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class Test036_fileUpload extends TestCaseBoilerPlate {
    @Test
    public void Test_fileUpload(){
        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement InputFile = driver.findElement(By.name("fileToUpload"));

        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);

        InputFile.sendKeys(workingDir+"/src/test/java/com/kuldeepkumar290497/ex011_fileUpload/TestData.txt");
        driver.findElement(By.name("submit"));

        waitJVM(5000);

        driver.close();
    }
}
