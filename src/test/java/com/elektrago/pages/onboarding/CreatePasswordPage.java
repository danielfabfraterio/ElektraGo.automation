package com.elektrago.pages.onboarding;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CreatePasswordPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]")
    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_password")
    public WebElement inputPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"ic show\"`][1]")
    @AndroidFindBy(id = "com.elektrago.elektrago:id/text_input_end_icon")
    public WebElement btnshowPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_confirm")
    public WebElement inputConfirmPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"ic show\"`][2]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Mostrar contraseña\"])[2]")
    public WebElement btnshowConfirmPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    private WebElement btnEnter;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Create\"`]")
    public WebElement btnCreate;

    public CreatePasswordPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()),this);
    }

    public void validate() {
        BaseUtils.waitUntilElementisPresent(inputPassword);
        Assert.isTrue(inputPassword.isDisplayed(), "Element is not present");
    }

    public void fillPassword(String password) {
        BaseUtils.fillUpField(inputPassword, password);
    }

    public void fillPasswordConfirm(String passwordConfirm) {
        BaseUtils.fillUpField(inputConfirmPassword, passwordConfirm);
    }

    public void tapContinue() {
        BaseUtils.clickOnElement(btnEnter);
        BaseUtils.clickOnElement(btnCreate);
    }
}
