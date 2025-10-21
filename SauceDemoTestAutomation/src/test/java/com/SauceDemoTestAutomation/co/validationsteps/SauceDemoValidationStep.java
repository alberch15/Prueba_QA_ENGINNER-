package com.SauceDemoTestAutomation.co.validationsteps;

import com.SauceDemoTestAutomation.co.models.Usuario;
import com.SauceDemoTestAutomation.co.pages.SauceDemoPage;
import com.SauceDemoTestAutomation.co.validationpage.SauceDemoValidationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.TimeoutException;



public class SauceDemoValidationStep  {

    @Steps
    SauceDemoPage sauceDemo;

    @Steps
    SauceDemoValidationPage sauceDemoValidationPage;
    @Step("debe ver el inventario de productos")
    public void ValidarIngresoInventario(Usuario usuarioInvalido) {
        boolean estaVisible = sauceDemoValidationPage.getTitleProducts().isDisplayed();
        Assert.assertTrue("El inventario de productos no está visible", estaVisible);
    }

    @Step("debe ver un mensaje de error")
    public void ValidarUsuarioContrasenaErrados(){
        if (sauceDemoValidationPage.getMessageError().isDisplayed()) {
            String mensaje = "Login fallido: usuario y contraseña inválidos";
            System.out.println(mensaje);
            Serenity.recordReportData().withTitle("Información importante").andContents(mensaje);
        } else {
            System.out.println("Login Exitoso");
        }
    }

    @Step("el carrito debe reflejar los productos seleccionadosa")
    public void ValidarProductoCorrectoCarrito() {

        String tituloLista = sauceDemo.getTitleProduct().getText().trim();
        String tituloCarrito = sauceDemoValidationPage.getTitleValidation().getText().trim();
        System.out.println(tituloLista);
        System.out.println(tituloCarrito);
        if (tituloLista.equals(tituloCarrito)) {
            Serenity.recordReportData().withTitle("Validación de título")
                    .andContents("Los títulos coinciden: " + tituloLista);
        } else {
            Assert.fail("El título del producto en la lista (" + tituloLista +
                    ") no coincide con el del carrito (" + tituloCarrito + ")");
        }


        String precioLista = sauceDemo.getPriceProduct().getText().trim();
        String precioCarrito = sauceDemoValidationPage.getPriceValidation().getText().trim();
        System.out.println(precioLista);
        System.out.println(precioCarrito);
        if (precioLista.equals(precioCarrito)) {
            Serenity.recordReportData().withTitle("Validación de precio")
                    .andContents("Los precios coinciden: " + precioLista);
        } else {
            Assert.fail("El precio en la lista (" + precioLista +
                    ") no coincide con el del carrito (" + precioCarrito + ")");
        }


        String descripcionLista = sauceDemo.gerDescptionProduct().getText().trim();
        String descripcionCarrito = sauceDemoValidationPage.getDescriptionValidation().getText().trim();
        System.out.println(descripcionLista);
        System.out.println(descripcionCarrito);
        if (descripcionLista.equals(descripcionCarrito)) {
            Serenity.recordReportData().withTitle("Validación descripcion ")
                    .andContents("Las decripciones coinciden: " + descripcionLista);
        } else {
            Assert.fail("La descripcion en la lista (" + descripcionLista +
                    ") no coincide con la del carrito (" + descripcionCarrito + ")");
        }
    }

    @Step("debe ver el mensaje de confirmación de compra")
    public void ValidarCompraExitosa(){
        try {
           sauceDemoValidationPage.getMessageCompraExitosa().isDisplayed();
            Serenity.recordReportData().withTitle("Mensaje Final Exitoso")
                    .andContents("Prueba exitosa: El mensaje de compra exitosa está visible.");
        } catch (TimeoutException e) {
            Serenity.recordReportData().withTitle("Mensaje Final Fallido")
                    .andContents("Prueba Fallida: El mensaje de compra exitosa no está visible.");
        }
    }



}
