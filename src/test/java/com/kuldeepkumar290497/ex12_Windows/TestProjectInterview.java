package com.kuldeepkumar290497.ex12_Windows;

import com.kuldeepkumar290497.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class TestProjectInterview extends TestCaseBoilerPlate {
@Test
    public void Test_interviewVWO_project(){
    driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
    driver.manage().window().maximize();

    waitJVM(5000);

    String parent_window = driver.getWindowHandle();
    System.out.println("parent:-> "+parent_window);

    List<WebElement> Heatmaps = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(Heatmaps.get(1)).click().build().perform();

    waitJVM(15000);

    Set<String> all_handles = driver.getWindowHandles();

    for (String handle : all_handles){
        if(!handle.equals(parent_window)){
            driver.switchTo().window(handle);
            //move to child window
            driver.switchTo().frame("heatmap-iframe");
            WebElement clickMap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
            clickMap.click();
        }
    }


}
}
