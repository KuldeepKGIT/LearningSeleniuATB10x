package com.kuldeepkumar290497.ex02_Selinium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium08 {
    @Description ("Open the URL")
    @Test
    public void test_selenium03(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
    }
}

