package com.SauceDemoTestAutomation.co.validationpage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class SauceDemoValidationPage extends PageObject {
    public WebElementFacade getTitleProducts() {
        return find(By.xpath("//span[@data-test='title' and text()='Products']"));
    }

    public WebElementFacade getMessageError(){
        return find(By.xpath("//h3[@data-test='error' and contains(text(), 'Epic sadface')]"));
    }

    public WebElementFacade getTitleValidation(){
        return find(By.xpath("//div[@class='inventory_item_name' and @data-test='inventory-item-name' and text()='Sauce Labs Backpack']"));
    }

    public WebElementFacade getPriceValidation(){
        return find(By.xpath("//button[@data-test='remove-sauce-labs-backpack']/preceding-sibling::div[@class='inventory_item_price']"));
    }

    public WebElementFacade getDescriptionValidation(){
        return find(By.xpath("//div[@class='inventory_item_desc' and @data-test='inventory-item-desc' and normalize-space(text())='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']\n"));
    }

    public WebElementFacade getMessageCompraExitosa(){
        return find(By.xpath("//h2[@class='complete-header' and @data-test='complete-header' and normalize-space(text())='Thank you for your order!']"));

    }
}
