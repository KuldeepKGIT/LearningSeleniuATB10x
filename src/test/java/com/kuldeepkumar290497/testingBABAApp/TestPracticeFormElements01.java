package com.kuldeepkumar290497.testingBABAApp;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPracticeFormElements01 extends TestCaseBoilerPlate {

    @Test
    public void Test001Elements(){
        driver.manage().window().maximize();
        driver.get("https://www.testingbaba.com/old/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='title']/following-sibling::button[contains(text(),'×')]")));
        closeBtn.click();
        WebElement PracticeForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item']/child::a[text()='Practice']")));
        PracticeForm.click();
        WebElement elements = driver.findElement(By.xpath("//h2[@class='mb-0']/button[@data-target='#elements']"));
        elements.click();
        WebElement textBox = driver.findElement(By.xpath("//div[@role='tablist']/a[text()='text box']"));
        textBox.click();
        WebElement nameInput = driver.findElement(By.xpath("//div[@class='col-md-6']/descendant::input[@id='fullname1']"));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys("Kuldeep Kumar");
        WebElement emailInput = driver.findElement(By.xpath("//div[@class='col-md-6']/descendant::input[@id='fullemail1']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
       emailInput.sendKeys("kuldeep@gmail.com");
        WebElement addressInput =driver.findElement(By.xpath("//textarea[@id='fulladdresh1']"));
        wait.until(ExpectedConditions.elementToBeClickable(addressInput));
        addressInput.sendKeys("Pasonda, Ghaziabad");
        WebElement pAddressInput =driver.findElement(By.xpath("//textarea[@id='paddresh1']"));
        wait.until(ExpectedConditions.elementToBeClickable(pAddressInput));
        pAddressInput.sendKeys("Pasonda, Ghaziabad");
        WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement formDetails = driver.findElement(By.xpath("//div[@class='col-md-6 mt-5']"));
        String form_details = formDetails.getText();
        Assert.assertTrue(formDetails.isDisplayed());
        System.out.println(form_details);



    }

}
