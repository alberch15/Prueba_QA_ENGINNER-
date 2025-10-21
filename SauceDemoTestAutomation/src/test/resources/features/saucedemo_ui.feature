@suite
Feature: Flujo principal de usuario en SauceDemo

  Background:
    Given el usuario abre la página de login

  @CP1
  Scenario: Login exitoso
    When ingresa credenciales válidas
    Then debe ver el inventario de productos

  @CP2
  Scenario: Login fallido
    When ingresa credenciales inválidas
    Then debe ver un mensaje de error

  @CP3
  Scenario: Agregar productos al carrito
    When ingresa credenciales válidas
    And agrega productos al carrito
    Then el carrito debe reflejar los productos seleccionadosa

  @CP4
  Scenario: Completar proceso de compra
    When ingresa credenciales válidas
    And agrega productos al carrito
    And completa el formulario de checkout
    Then debe ver el mensaje de confirmación de compra