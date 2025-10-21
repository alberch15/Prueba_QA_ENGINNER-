package com.SauceDemoTestAutomation.co.steps;

import com.SauceDemoTestAutomation.co.models.InformacionPersonal;
import com.SauceDemoTestAutomation.co.models.Usuario;
import com.SauceDemoTestAutomation.co.pages.SauceDemoPage;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoStep {

    @Steps
    SauceDemoPage sauceDemoPage;
    @Before
    public void configureWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Step("ingresa credenciales válidas")
    public void IngresarCredencialesValidas(Usuario usuario) throws InterruptedException {
        sauceDemoPage.withTimeoutOf(Duration.ofSeconds(15))
                .waitFor(ExpectedConditions.visibilityOf(sauceDemoPage.getTxtUser()));
        sauceDemoPage.getTxtUser().sendKeys(usuario.getUsername());
        sauceDemoPage.getTxtPassword().sendKeys(usuario.getPassword());
        sauceDemoPage.getBtnLogin().click();
    }

    @Step("ingresa credenciales inválidas")
    public void IngresarCredencialesInvalidas(Usuario usuario) throws InterruptedException {
        sauceDemoPage.withTimeoutOf(Duration.ofSeconds(15))
                .waitFor(ExpectedConditions.visibilityOf(sauceDemoPage.getTxtUser()));
        sauceDemoPage.getTxtUser().sendKeys(usuario.getUsername());
        sauceDemoPage.getTxtPassword().sendKeys(usuario.getPassword());
        sauceDemoPage.getBtnLogin().click();
    }

    @Step("agrega productos al carrito")
    public void AgregarProductoCarrito(){
        sauceDemoPage.getBtnAddProduct().click();
        sauceDemoPage.getBuyCar().click();
    }

    @Step("completa el formulario de checkout")
    public void CompletarCheckout(InformacionPersonal informacionPersonal){

        sauceDemoPage.getBtnCheckout().click();
        sauceDemoPage.withTimeoutOf(Duration.ofSeconds(15))
                .waitFor(ExpectedConditions.visibilityOf(sauceDemoPage.getTxtFirstName()));
        sauceDemoPage.getTxtFirstName().sendKeys(informacionPersonal.getFirstName());
        sauceDemoPage.getTxtLastName().sendKeys(informacionPersonal.getLastName());
        sauceDemoPage.getTxtPostalCode().sendKeys(informacionPersonal.getPostalCode());
        sauceDemoPage.getBtnContinuar().click();
        sauceDemoPage.withTimeoutOf(Duration.ofSeconds(15))
                .waitFor(ExpectedConditions.visibilityOf(sauceDemoPage.getBtnFinish()));
        sauceDemoPage.getBtnFinish().click();
    }


}
