package com.SauceDemoTestAutomation.co.website;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;


public class WebSiteSauce {

    @Steps(shared = true)
    PageObject SauceDemo;

    @Step("Navegar al sitio web")
    public void navigateTo(String url){
        SauceDemo.setDefaultBaseUrl(url);
        SauceDemo.open();
    }
}
