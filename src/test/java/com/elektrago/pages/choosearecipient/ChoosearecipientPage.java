package com.elektrago.pages.choosearecipient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChoosearecipientPage {

    @AndroidFindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.elektrago.elektrago:id/contact_data\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement firstRecipientAvailable;

    @AndroidFindBy(id="com.elektrago.elektrago:id/buttonAddContact")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Agregar beneficiario\"`]")
    public WebElement addContactButton;

    @AndroidFindBy(id="com.elektrago.elektrago:id/searchViewText")
    @iOSXCUITFindBy(accessibility = "Buscar beneficiario")
    public WebElement seachBeneficiary;

    @AndroidFindBy(id="com.elektrago.elektrago:id/contact_data")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Daniel  Lopez \"`]")
    public WebElement resultBeneficiarySearch;

    @AndroidFindBy(id="com.elektrago.elektrago:id/name")
    public WebElement mobileCodeDropdwn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/editTextNumber")
    public WebElement mobileNumberField;

    @AndroidFindBy(id="com.elektrago.elektrago:id/editTextFirstName")
    public WebElement firstNameField;

    @AndroidFindBy(id="com.elektrago.elektrago:id/editTextFirstLastName")
    public WebElement lastNameField;

    @AndroidFindBy(id="com.elektrago.elektrago:id/editTextSecondLastName")
    public WebElement secondLastNameField;

    @AndroidFindBy(id="com.elektrago.elektrago:id/button_add")
    @iOSXCUITFindBy(accessibility = "Agregar")
    public WebElement addButton;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/buttonImportContact")
    @iOSXCUITFindBy(accessibility = "Importar contacto")
    public WebElement importContactButton;

    
    public ChoosearecipientPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateChooseARecipientPage() {
        BaseUtils.waitUntilElementisPresent(firstRecipientAvailable);
        Assert.isTrue(firstRecipientAvailable.isDisplayed(), "Element is not present");
    }

    public void tapsOnFirstRecipientAvailable() {
        firstRecipientAvailable.click();
    }

    /**
     * Método que realiza scroll en la lista de beneficiarios para hacer visible el elemento
     * que contenga el texto del nombre del beneficiario.
     *
     * @param beneficiaryName El nombre (o parte) del beneficiario a buscar.
     * @return WebElement correspondiente al beneficiario.
     */
    public void scrollToBeneficiary(String beneficiaryName) {
        String xpath = "//android.widget.TextView[@resource-id='com.elektrago.elektrago:id/textViewName' and contains(@text, '" + beneficiaryName + "')]";
        WebElement element;
        boolean elementFound = false;
        while (!elementFound) {
            try {
                element = AppiumDriverFactory.getDriver().findElement(By.xpath(xpath));
                BaseUtils.scrollUntilElementIsPresent(element);
            } catch (Exception e) {
                System.err.println("Error al encontrar elemento:"+e.toString());
             }
        }
    }

    /**
     * Método para pulsar dinámicamente el botón "Invitar" correspondiente a un beneficiario.
     * Primero hace scroll hasta el beneficiario y luego localiza el botón usando un XPath que
     * relaciona el nombre del beneficiario con su contenedor.
     *
     * @param beneficiaryName El nombre del beneficiario.
     */
    public void clickInviteButton(String beneficiaryName) {
        // Asegurarse de que el beneficiario sea visible haciendo scroll
        scrollToBeneficiary(beneficiaryName);
        WebElement inviteButton = AppiumDriverFactory.getDriver().findElement(By.xpath(
            "//android.view.ViewGroup[@resource-id='com.elektrago.elektrago:id/contact_data']" +
            "[.//android.widget.TextView[@resource-id='com.elektrago.elektrago:id/textViewName' and contains(@text, '" + beneficiaryName + "')]]" +
            "//android.widget.Button[@resource-id='com.elektrago.elektrago:id/button_invite']"
        ));
        BaseUtils.clickOnElement(inviteButton);
    }

    /**
     * Método para pulsar dinámicamente el botón "Editar" correspondiente a un beneficiario.
     * Primero hace scroll hasta el beneficiario y luego localiza el botón "Editar" usando un XPath
     * que relaciona el nombre del beneficiario con su contenedor.
     *
     * @param beneficiaryName El nombre del beneficiario.
     */
    public void clickEditButton(String beneficiaryName) {
        // Asegurarse de que el beneficiario sea visible haciendo scroll
        scrollToBeneficiary(beneficiaryName);
        WebElement editButton = AppiumDriverFactory.getDriver().findElement(By.xpath(
            "//android.view.ViewGroup[@resource-id='com.elektrago.elektrago:id/contact_data']" +
            "[.//android.widget.TextView[@resource-id='com.elektrago.elektrago:id/textViewName' and contains(@text, '" + beneficiaryName + "')]]" +
            "//android.widget.TextView[@resource-id='com.elektrago.elektrago:id/textViewEdit']"
        ));
        BaseUtils.clickOnElement(editButton);
    }

    /**
     * Función que, a partir del nombre del beneficiario, construye el XPath para el contenedor 
     * (elemento con resource-id "com.elektrago.elektrago:id/contact_data") y hace click sobre él.
     *
     * @param beneficiaryName Nombre del beneficiario a buscar.
     */
    public void clickBeneficiaryByName(String beneficiaryName) {
        String xpath = "//android.view.ViewGroup[@resource-id='com.elektrago.elektrago:id/contact_data']" +
                       "[.//android.widget.TextView[@resource-id='com.elektrago.elektrago:id/textViewName' and contains(@text, '" 
                       + beneficiaryName + "')]]";
        WebElement beneficiaryElement = AppiumDriverFactory.getDriver().findElement(By.xpath(xpath));
        BaseUtils.clickOnElement(beneficiaryElement);
    }
}
