package com.kuldeepkumar290497.ex09_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;
import java.util.List;

import static com.kuldeepkumar290497.ex07_waitHelpers.WaitHelpers.waitJVM;

public class Test_Selenium031 {
    @Description("Test Case description")
    @Test( groups ="QA" )
    public void Test_DynamicWebTables(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/webtable1.html");

        // XPath : //table[@summary="Sample Table"]/tbody

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        List<WebElement> Rows_table = table.findElements(By.tagName("tr"));

        for(int i = 0; i< Rows_table.size();i++){
            List<WebElement> column = Rows_table.get(i).findElements(By.tagName("td"));
            for(WebElement c : column){
                System.out.println(c.getText());
            }
        }
        waitJVM(10);
driver.quit();
    }
}
