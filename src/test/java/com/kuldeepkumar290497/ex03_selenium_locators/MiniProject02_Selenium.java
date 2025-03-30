package com.kuldeepkumar290497.ex03_selenium_locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MiniProject02_Selenium {
    @Owner("Kuldeep")
    @Description("Verify that invalid email gives error on signup page")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void vwo_free_trail_error_verify(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/");
        //  <a
        //  href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        //  class="text-link"
        //  data-qa="bericafeqo">
        //  Start a free trial
        //  </a>
        WebElement free_trial_link = driver.findElement(By.partialLinkText("Start"));
        free_trial_link.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));
        WebElement EmailInput = driver.findElement(By.id("page-v1-step1-email"));
        EmailInput.sendKeys("ABC");
        WebElement CheckBox = driver.findElement(By.name("gdpr_consent_checkbox"));
        CheckBox.click();
        List<WebElement> ButtonList = driver.findElements(By.tagName("button"));
        ButtonList.get(0).click();
        // <div
        // class="C($color-red) Fz($font-size-12)
        // Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.
        // </div>
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement Error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertTrue(Error_message.isDisplayed());
        Assert.assertEquals(Error_message.getText(),"The email address you entered is incorrect.");
        driver.quit();
    }

}
