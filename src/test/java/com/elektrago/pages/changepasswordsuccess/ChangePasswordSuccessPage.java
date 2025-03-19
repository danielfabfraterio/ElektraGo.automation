package com.elektrago.pages.changepasswordsuccess;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ChangePasswordSuccessPage {
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Back to login\"`]")
  public WebElement btnBackToLogin;

  public ChangePasswordSuccessPage() {
    PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
  }

  public void validateChangePasswordSuccess() {
    BaseUtils.waitUntilElementisPresent(btnBackToLogin);
    Assert.isTrue(btnBackToLogin.isDisplayed(), "Element is not present");
  }

  public void tapBackToLogin() {
    BaseUtils.clickOnElement(btnBackToLogin);
  }
}
