package com.elektrago.pages.loginonetimecode;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;

public class LoginOneTimeCodePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Login with a One-time code\"`]")
    private WebElement title;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[1]")
    public WebElement inputVerificationCode1;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[2]")
    public WebElement inputVerificationCode2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[3]")
    public WebElement inputVerificationCode3;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[4]")
    public WebElement inputVerificationCode4;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[5]")
    public WebElement inputVerificationCode5;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[6]")
    public WebElement inputVerificationCode6;

//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Back\"`][2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Back\"`][2]")
    private WebElement btnBack;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    private WebElement btnDone;

    public LoginOneTimeCodePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateLoginOneTimeCodePage() {
        BaseUtils.waitUntilElementisPresent(title);
        Assert.isTrue(title.isDisplayed(), "Element is not present");
    }

    public void enterOTP(String otp) {
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

    public void theUserTapsOnBtnDone() {
        BaseUtils.clickOnElement(btnDone);
    }

    public void theUserTapsOnBtnBack() {
        BaseUtils.clickOnElement(btnBack);
    }
}
