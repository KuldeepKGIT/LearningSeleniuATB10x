package com.kuldeepkumar290497.ex03_selenium_locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_Selenium18 {
    @Description("Verify free Trial Link")
    @Test
    public void Test_free_trial_Link(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/");
      //  <a
              //  href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        //  class="text-link"
        //  data-qa="bericafeqo">
        //  Start a free trial
        //  </a>
        WebElement free_trial_link = driver.findElement(By.linkText("Start a free trial"));
        free_trial_link.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }

