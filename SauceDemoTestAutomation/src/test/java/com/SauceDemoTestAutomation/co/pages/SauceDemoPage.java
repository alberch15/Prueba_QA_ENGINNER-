package com.SauceDemoTestAutomation.co.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class SauceDemoPage extends PageObject {
    public WebElementFacade getTxtUser() {
        return find(By.id("user-name"));
    }

    public WebElementFacade getTxtPassword() {
        return find(By.id("password"));
    }

    public WebElementFacade getBtnLogin() {
        return find(By.id("login-button"));
    }

    public WebElementFacade getTitleProduct(){
        return find(By.xpath("//div[text()='Sauce Labs Backpack']"));
    }

    public WebElementFacade getPriceProduct(){
        return find((By.xpath("//div[.//button[@data-test='remove-sauce-labs-backpack']]/div[@class='inventory_item_price']")));
    }

    public WebElementFacade gerDescptionProduct(){
        return find(By.xpath("//div[@class='inventory_item_desc' and @data-test='inventory-item-desc' and normalize-space(text())='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']"));
    }

    public WebElementFacade getBtnAddProduct(){
        return find(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElementFacade getBuyCar(){
        return find(By.xpath("//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']"));
    }

    public WebElementFacade getBtnCheckout(){
        return find(By.id("checkout"));
    }

    public WebElementFacade getTxtFirstName(){
        return find(By.id("first-name"));
    }

    public WebElementFacade getTxtLastName(){
        return find(By.id("last-name"));
    }

    public WebElementFacade getTxtPostalCode(){
        return find(By.id("postal-code"));
    }

    public WebElementFacade getBtnContinuar(){
        return find(By.id("continue"));
    }

    public WebElementFacade getBtnFinish(){
        return find(By.id("finish"));
    }


}

//div[@class='inventory_item_name' and @data-test='inventory-item-name' and text()='Sauce Labs Backpack']
//div[@class='inventory_item_name' and @data-test='inventory-item-name' and text()='Sauce Labs Backpack']