package com.kuldeepkumar290497.ex09_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_Selenium30
{
    @Description("Test case description")
    @Test
    public void Test_WebTable() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://awesomeqa.com/webtable.html");

         //Xpath: //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]
        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";
        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
for (int i=2; i<=row;i++){
    for(int j=1; j<=column; j++){
        String Dynamic_Xpath = first_part+i+second_part+j+third_part;
//        System.out.println(Dynamic_Xpath);
        String data =driver.findElement(By.xpath(Dynamic_Xpath)).getText();
//        System.out.println(data);
        if(data.contains("Helen Bennett")){
            String Company_Xpath = Dynamic_Xpath+"/preceding-sibling::td";
            String Company_text = driver.findElement(By.xpath(Company_Xpath)).getText();
            String country_path = Dynamic_Xpath+"/following-sibling::td";
            String country_text = driver.findElement(By.xpath(country_path)).getText();
            System.out.println("------");
            System.out.println(Company_text+"Helen Bennett is In - " + country_text);
        }
    }
}


    }
}
