package com.kuldeepkumar290497.ex015_DataDriven;


import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.checkVisibility;
import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class Lab043_DDT_VWO_login extends TestCaseBoilerPlate {

@Test(dataProvider = "getData")
    public void Test_appVWO_login(String email, String password){
    driver.navigate().to("https://app.vwo.com");
    System.out.println(driver.getTitle());

    waitJVM(3000);

    Assert.assertEquals(driver.getTitle(), "Login - VWO");
    Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

    // 1. Find the email inputBox and enter the email
    WebElement emailInputBox = driver.findElement(By.id("login-username"));
    emailInputBox.sendKeys(email);

    WebElement passwordInputBox = driver.findElement(By.name("password"));
    passwordInputBox.sendKeys(password);


    WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
    buttonSubmit.click();

    checkVisibility(driver,By.className("notification-box-description"),3);

    WebElement error_message = driver.findElement(By.className("notification-box-description"));
    Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

}
@DataProvider
    public Object[][] getData(){
    return UtilExcel.getTestDataFromExcel("sheet1");
}
}
