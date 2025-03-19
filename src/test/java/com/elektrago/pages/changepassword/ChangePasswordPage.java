package com.elektrago.pages.changepassword;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]")
    public WebElement inputPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[2]")
    public WebElement inputConfirmPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Change\"`]")
    public WebElement btnChange;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    public WebElement btnDone;

  public ChangePasswordPage() {
    PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
  }

  public void validateChangePassword() {
    BaseUtils.waitUntilElementisPresent(inputPassword);
    Assert.isTrue(inputPassword.isDisplayed(), "Element is not present");
  }

  public void fillPassword(String password) {
    BaseUtils.fillUpField(inputPassword, password);
  }

  public void fillPasswordConfirm(String confirmPassword) {
    BaseUtils.fillUpField(inputConfirmPassword, confirmPassword);
    BaseUtils.clickOnElement(btnDone);
  }

  public void tapChange() {
    BaseUtils.clickOnElement(btnChange);
  }
}
