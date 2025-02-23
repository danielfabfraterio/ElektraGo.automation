package com.elektrago.pages.sendmoney;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class SendMoney {

    // Botón "Editar" (contenedor de favoritos)
    @AndroidFindBy(id = "com.elektrago.elektrago:id/editFavoritesButton")
    @iOSXCUITFindBy(accessibility = "Editar")
    public WebElement editFavoritesButton;

    // RecyclerView de "Send Again"
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.elektrago.elektrago:id/container\"])[1]")
    public WebElement sendAgainList;

    // Botón "México y otros países"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_mexico")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement buttonMexico;

    // Botón "Dentro de Estados Unidos"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_ach_transfer")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    public WebElement buttonAchTransfer;

    // Botón "Between Elektra Go users"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_usa")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[3]")
    public WebElement buttonP2P;

    // Botón "Cancelar"
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_cancel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Cancelar\"`]")
    public WebElement buttonCancel;


    public SendMoney() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }


    public boolean isSendAgainListDisplayed() {
        return sendAgainList.isDisplayed();
    }

}
