package com.elektrago.pages.verifyemail;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VerifyEmailPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    public WebElement inputVerificationCode1;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public WebElement inputVerificationCode2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[3]")
    public WebElement inputVerificationCode3;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[4]")
    public WebElement inputVerificationCode4;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[5]")
    public WebElement inputVerificationCode5;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[6]")
    public WebElement inputVerificationCode6;

    public VerifyEmailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateVerifyEmailPage() {
        BaseUtils.waitUntilElementisPresent(inputVerificationCode6);
        Assert.isTrue(inputVerificationCode6.isDisplayed(), "Element is not present");
    }

    public void enterVerificationCode(String otp) {
        if (!otp.isEmpty()) {
            for (int i = 0; i < otp.length(); i++) {
                String indCode = String.valueOf(otp.charAt(i));
                switch (i) {
                    case 0:
                        BaseUtils.fillUpField(inputVerificationCode1, indCode);
                        break;
                    case 1:
                        BaseUtils.fillUpField(inputVerificationCode2, indCode);
                        break;
                    case 2:
                        BaseUtils.fillUpField(inputVerificationCode3, indCode);
                        break;
                    case 3:
                        BaseUtils.fillUpField(inputVerificationCode4, indCode);
                        break;
                    case 4:
                        BaseUtils.fillUpField(inputVerificationCode5, indCode);
                        break;
                    case 5:
                        BaseUtils.fillUpField(inputVerificationCode6, indCode);
                        break;
                }
            }
        }
    }
}
