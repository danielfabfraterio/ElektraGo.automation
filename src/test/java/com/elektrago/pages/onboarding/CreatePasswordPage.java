package com.elektrago.pages.onboarding;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CreatePasswordPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_password")
    public WebElement inputPassword;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/text_input_end_icon")
    public WebElement btnshowPassword;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_confirm")
    public WebElement inputConfirmPassword;

    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Mostrar contraseña\"])[2]")
    public WebElement btnshowConfirmPassword;

    public CreatePasswordPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()),this);
    }
}
