package com.SauceDemoTestAutomation.co.definitions;


import com.SauceDemoTestAutomation.co.models.InformacionPersonal;
import com.SauceDemoTestAutomation.co.models.Usuario;
import com.SauceDemoTestAutomation.co.steps.SauceDemoStep;
import com.SauceDemoTestAutomation.co.validationsteps.SauceDemoValidationStep;
import com.SauceDemoTestAutomation.co.website.WebSiteSauce;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SauceDemoDefinition {
    Usuario usuarioValido = new Usuario("standard_user", "secret_sauce");
    Usuario usuarioInvalido = new Usuario("fake_user", "fake_pass");
    InformacionPersonal informacionPersonal = new InformacionPersonal("Carlos", "Caballero", "080007");
    @Steps(shared = true)
    WebSiteSauce url;

    @Steps(shared = true)
    SauceDemoStep sauce;

    @Steps(shared = true)
    SauceDemoValidationStep sauceValidation;

    @Given("el usuario abre la página de login")
    public void el_usuario_abre_la_página_de_login() {
        url.navigateTo("https://www.saucedemo.com/");
    }
    @When("ingresa credenciales válidas")
    public void ingresa_credenciales_válidas() throws InterruptedException {
        sauce.IngresarCredencialesValidas(usuarioValido);
    }
    @Then("debe ver el inventario de productos")
    public void debe_ver_el_inventario_de_productos() {
        sauceValidation.ValidarIngresoInventario(usuarioInvalido);
    }

    @When("ingresa credenciales inválidas")
    public void ingresa_credenciales_inválidas() throws InterruptedException {
        sauce.IngresarCredencialesInvalidas(usuarioInvalido);
    }
    @Then("debe ver un mensaje de error")
    public void debe_ver_un_mensaje_de_error() {
        sauceValidation.ValidarUsuarioContrasenaErrados();
    }

    @When("agrega productos al carrito")
    public void agrega_productos_al_carrito() {
        sauce.AgregarProductoCarrito();
    }
    @Then("el carrito debe reflejar los productos seleccionadosa")
    public void el_carrito_debe_reflejar_los_productos_seleccionadosa() {
        sauceValidation.ValidarProductoCorrectoCarrito();
    }

    @When("completa el formulario de checkout")
    public void completa_el_formulario_de_checkout() {
        sauce.CompletarCheckout(informacionPersonal);
    }
    @Then("debe ver el mensaje de confirmación de compra")
    public void debe_ver_el_mensaje_de_confirmación_de_compra() {
        sauceValidation.ValidarCompraExitosa();
    }



}
