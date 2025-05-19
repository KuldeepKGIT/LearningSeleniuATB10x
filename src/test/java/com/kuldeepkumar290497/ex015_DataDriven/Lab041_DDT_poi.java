package com.kuldeepkumar290497.ex015_DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.*;


import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.checkVisibility;

public class Lab041_DDT_poi {
    private static final ThreadLocal<EdgeDriver> driver = new ThreadLocal<>();

    public EdgeDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver.set(new EdgeDriver(options));

    }
    @Test(dataProvider = "vwoData")
    public void Test_VWO_login(String email, String password){

        System.out.println(email +" - "+ password);
        getDriver().get("https://app.vwo.com");
        // 1. Find the email inputBox and enter the email
        WebElement emailInputBox = getDriver().findElement(By.id("login-username"));
        emailInputBox.sendKeys(email);

        WebElement passwordInputBox = getDriver().findElement(By.name("password"));
        passwordInputBox.sendKeys(password);


        WebElement buttonSubmit = getDriver().findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        checkVisibility(getDriver(),By.className("notification-box-description"),3);

        WebElement error_message = getDriver().findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
    }

    @DataProvider(name = "vwoData",parallel = true)
    public Object[][] getData(){
        return new Object[][]{ new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass124"}
        };
    }
    @DataProvider
    public Object[][] getDataxlsx(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return new Object[][]{};
    }
    @AfterMethod
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().quit();
        driver.remove();
    }
}
