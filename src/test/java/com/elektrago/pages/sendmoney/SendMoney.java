package com.elektrago.pages.sendmoney;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SendMoney {

    // Botón "Editar" (contenedor de favoritos)
    @AndroidFindBy(id = "com.elektrago.elektrago:id/editFavoritesButton")
    public WebElement editFavoritesButton;
    // RecyclerView de "Send Again"
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.elektrago.elektrago:id/container\"])[1]")
    public WebElement sendAgainList;

    // Botón "México y otros países"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_mexico")
    public WebElement buttonMexico;

    // Botón "Dentro de Estados Unidos"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_ach_transfer")
    public WebElement buttonAchTransfer;

    // Botón "Between Elektra Go users"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_usa")
    public WebElement buttonP2P;

    // Botón "Cancelar"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    public WebElement buttonCancel;


    public SendMoney() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }


    public boolean isSendAgainListDisplayed() {
        return sendAgainList.isDisplayed();
    }

}
