package com.elektrago.pages.p2p;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class P2PPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='$0.00']")
    public WebElement inputAmount;

    @AndroidFindBy(id="com.elektrago.elektrago:id/text_error")
    @iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther")
    public WebElement errorText;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    public WebElement buttonContinue;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Cancelar'])[2]")
    public WebElement buttonCancel;

    // Título de la pantalla: "Confirmar transferencia"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/text_title")
    @iOSXCUITFindBy(accessibility = "Confirmar transferencia")
    public WebElement title;

    // Botón Atrás
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_back")
    @iOSXCUITFindBy(accessibility = "Atrás")
    public WebElement backButton;
    
    // Campo para ingresar mensaje (descripción)
    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_description")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextView")
    public WebElement inputDescription;
    
    // Botón para seleccionar GIF
    @AndroidFindBy(id = "com.elektrago.elektrago:id/btn_gif")
    @iOSXCUITFindBy(accessibility = "gif icon")
    public WebElement gifButton;
    
    // Botón Enviar
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_send_money")
    @iOSXCUITFindBy(accessibility = "Enviar")
    public WebElement sendButton;
    
    // Botón Cancelar
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Cancelar'])[2]")
    public WebElement cancelButton;

    // Titulo Dinero Enviado!
    @AndroidFindBy(id= "com.elektrago.elektrago:id/text_title")
    @iOSXCUITFindBy(accessibility = "img_money_sent _success")
    public WebElement moneySent;

    // Boton Compartir!
    @AndroidFindBy(id= "com.elektrago.elektrago:id/button_share")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Compartir recibo con\"`]")
    public WebElement btnShare;

    //Boton Hecho
    @AndroidFindBy(id="com.elektrago.elektrago:id/button_home")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Hecho\"`]")
    public WebElement btnDone;

    public P2PPage(){
                PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);

    }

    public void clickBackButton() {
        backButton.click();
    }
    
    public void enterDescription(String description) {
        inputDescription.clear();
        inputDescription.sendKeys(description);
    }
    
    public void clickGifButton() {
        gifButton.click();
    }
    
    public void clickSendButton() {
        sendButton.click();
    }
    
    public void clickCancelButton() {
        cancelButton.click();
    }
    
}
