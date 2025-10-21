package com.SauceDemoTestAutomation.co;


import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/saucedemo_ui.feature",
        glue = "com.SauceDemoTestAutomation.co.definitions",
        tags = "@suite"

)
public class Runner {
    @BeforeClass
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

}

