package com.elektrago.pages.sendmoney;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SendMoney {

    // Botón "Editar" (contenedor de favoritos)
    @AndroidFindBy(id = "com.elektrago.elektrago:id/editFavoritesButton")
    private WebElement editFavoritesButton;
    // RecyclerView de "Send Again"
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.elektrago.elektrago:id/container\"])[1]")
    private WebElement sendAgainList;

    // Botón "México y otros países"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_mexico")
    private WebElement buttonMexico;

    // Botón "Dentro de Estados Unidos"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_ach_transfer")
    private WebElement buttonAchTransfer;

    // Botón "Between Elektra Go users"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_usa")
    private WebElement buttonUSA;

    // Botón "Cancelar"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    private WebElement buttonCancel;


    public SendMoney() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    // Métodos para interactuar con los elementos de la página

    public void clickEditFavorites() {
        editFavoritesButton.click();
    }

    public boolean isSendAgainListDisplayed() {
        return sendAgainList.isDisplayed();
    }

    public void clickButtonMexico() {
        buttonMexico.click();
    }

    public void clickButtonAchTransfer() {
        buttonAchTransfer.click();
    }

    public void clickButtonUSA() {
        buttonUSA.click();
    }

    public void clickButtonCancel() {
        buttonCancel.click();
    }

}
