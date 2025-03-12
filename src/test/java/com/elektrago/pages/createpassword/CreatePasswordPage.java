//public class CreatePasswordPage {
//  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Password\"`]")
//  private WebElement inputPassword;
//
//  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Confirm Password\"`]")
//  private WebElement inputConfirmPassword;
//
//  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
//  private WebElement btnContinue;
//
//  public CreatePasswordPage() {
//    PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
//  }
//
//  public void validate() {
//    BaseUtils.waitUntilElementisPresent(inputPassword);
//    Assert.isTrue(inputPassword.isDisplayed(), "Element is not present");
//  }
//
// public void inputPassword(String password) {
//BaseUtils.fillUpField(inputPassword, password);
// }
//
// public void inputConfirmPassword(String confirmPassword) {
//BaseUtils.fillUpField(inputConfirmPassword, confirmPassword);
// }
//
// public void clickContinue() {
//BaseUtils.clickElement(btnContinue);
// }
//
//}