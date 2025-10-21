# Proyecto de Automatización – SauceDemo

## 📘 Descripción General
Este proyecto implementa la automatización del flujo principal de usuario en la aplicación web **SauceDemo**, utilizando el framework **Serenity BDD** con **Cucumber**, bajo el patrón de diseño **Page Object Model (POM)**.

El objetivo principal es validar los flujos críticos del sistema:
1. Inicio de sesión exitoso.  
2. Inicio de sesión fallido.  
3. Agregar productos al carrito.  
4. Completar el proceso de compra.

---

##  Tecnologías y Herramientas Utilizadas

| Herramienta | Versión | Descripción |
|--------------|----------|-------------|
| **Java** | 17 | Lenguaje base para la automatización |
| **Maven** | 3.9+ | Gestión de dependencias y ejecución del proyecto |
| **Serenity BDD** | 4.2.16 | Framework principal de reporting y orquestación |
| **Cucumber** | Integrado en Serenity | Estructuración de pruebas con Gherkin |
| **Selenium WebDriver** | 4.29.0 | Interacción con el navegador |
| **WebDriverManager** | 5.9.3 | Administración automática de drivers |
| **JUnit** | 5.12.0 | Ejecutor de pruebas |

---

##  Estructura del Proyecto

src
└── test
├── java
│ ├── com.SauceDemoTestAutomation.co.pages
│ ├── com.SauceDemoTestAutomation.co.steps
│ ├── com.SauceDemoTestAutomation.co.models
│ └── com.SauceDemoTestAutomation.co.runners
└── resources
└── features
└── SauceDemo.feature

markdown
Copiar código

- **pages/** → Contiene los objetos de página (POM) con los localizadores y acciones sobre la UI.  
- **steps/** → Contiene la lógica de negocio y acciones que conectan los feature steps con los PageObjects.  
- **models/** → Define clases modelo como `Usuario` e `InformacionPersonal`.  
- **features/** → Contiene los escenarios escritos en Gherkin.  
- **runners/** → Define la clase ejecutora con las configuraciones de Serenity y Cucumber.

---

##  Escenarios Automatizados

**Feature:** Flujo principal de usuario en SauceDemo  
1. **Login exitoso:** Verifica que el usuario pueda autenticarse correctamente.  
2. **Login fallido:** Valida la aparición del mensaje de error ante credenciales inválidas.  
3. **Agregar productos al carrito:** Comprueba que los productos seleccionados se reflejen en el carrito.  
4. **Completar proceso de compra:** Simula el flujo completo de checkout hasta la confirmación.

---

##  Elementos Clave del Script

- **Locators:**  
  Se utilizan estrategias como `By.id()` y `By.xpath()` para identificar elementos de manera precisa.  
  Ejemplo:  
  ```java
  public WebElementFacade getBtnLogin() {
      return find(By.id("login-button"));
  }
Waits:
Se usan métodos de Serenity combinados con ExpectedConditions para sincronización.

java
Copiar código
sauceDemoPage.withTimeoutOf(Duration.ofSeconds(15))
             .waitFor(ExpectedConditions.visibilityOf(sauceDemoPage.getBtnFinish()));
Assertions:
Las verificaciones se realizan implícitamente mediante validaciones de visibilidad o existencia de elementos, aunque pueden integrarse con Assertions.assertTrue(...) para mayor control.

 Ejecución del Proyecto
 Requisitos Previos
Tener instalado Java 17 y Maven 3.9+.

Google Chrome actualizado.

 Comando de Ejecución
Desde la raíz del proyecto, ejecutar:

bash
Copiar código
mvn clean verify
Esto:

Descarga las dependencias necesarias.

Ejecuta los escenarios de Cucumber.

Genera el reporte Serenity.

 Reportes Generados
Una vez ejecutadas las pruebas, Serenity genera los reportes en:

bash
Copiar código
target/site/serenity/index.html# Prueba_QA_ENGINNER-
