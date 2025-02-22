package com.elektrago.pages.p2p;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P2PPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_amount")
    public WebElement inputAmount;

    @AndroidFindBy(id="com.elektrago.elektrago:id/text_error")
    public WebElement errorText;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    public WebElement buttonContinue;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    public WebElement buttonCancel;

    // Título de la pantalla: "Confirmar transferencia"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/text_title")
    public WebElement title;

    // Botón Atrás
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_back")
    public WebElement backButton;
    
    // Campo para ingresar mensaje (descripción)
    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_description")
    public WebElement inputDescription;
    
    // Botón para seleccionar GIF
    @AndroidFindBy(id = "com.elektrago.elektrago:id/btn_gif")
    public WebElement gifButton;
    
    // Botón Enviar
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_send_money")
    public WebElement sendButton;
    
    // Botón Cancelar
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    public WebElement cancelButton;

    // Titulo Dinero Enviado!
    @AndroidFindBy(id= "com.elektrago.elektrago:id/text_title")
    public WebElement moneySent;

    // Boton Compartir!
    @AndroidFindBy(id= "com.elektrago.elektrago:id/button_share")
    public WebElement btnShare;

    //Boton Hecho
    @AndroidFindBy(id="com.elektrago.elektrago:id/button_home")
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
