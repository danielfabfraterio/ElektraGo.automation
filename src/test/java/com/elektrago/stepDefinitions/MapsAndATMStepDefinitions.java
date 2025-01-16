package com.elektrago.stepDefinitions;
import com.elektrago.pages.addcashstore.AddCashStore;
import com.elektrago.pages.home.HomePage;
import com.elektrago.pages.mapsandatms.MapsAndATMPage;
import com.elektrago.utils.BaseUtils;

import io.cucumber.java.en.*;

public class MapsAndATMStepDefinitions {
    HomePage homePage;
    MapsAndATMPage mapsAndATMsPage;
    AddCashStore addCashStore;

    @Given("Cost Calculator is displayed")
    public void costCalculatorIsDisplayed(){
        homePage = new HomePage();
        homePage.validateHomePage();
    }

    @When("Select Maps and ATMs")
    public void SelectMapsandATMs() {
        homePage.mapsAtm.click();
    }

    @Then("Map with location is displayed")
    public void Mapwithlocationisdisplayed() {
        mapsAndATMsPage = new MapsAndATMPage();
        mapsAndATMsPage.validateMapsAndATMs();
    }

    @When("Tap on Find Location")
    public void TaponFindLocation() {
        mapsAndATMsPage.inputSearchLocation.click();

    }

    @Then("Map is displayed with new location")
    public void MapisdisplayedWithNewLocation() {
        BaseUtils.waitUntilElementisPresent(mapsAndATMsPage.btnSearchThisArea);
    }

    @When("Fill in with {string}")
    public void Fillinwith(String location) {
        mapsAndATMsPage.inputSearchLocation.sendKeys(location);
        BaseUtils.waitUntilElementisPresent(mapsAndATMsPage.btnBestResult);
        mapsAndATMsPage.btnBestResult.click();
    }

    @Then("Map is displayed with the selected filter {string}")
    public void Mapisdisplayedwiththeselectedfilter(String filterSelected) {
        mapsAndATMsPage.verifyFilterSelected(filterSelected);
    }

    @When("Select {string}")
    public void Select(String option) {
        mapsAndATMsPage.selectFilter(option);
    }

    @When("Tap on Filter {string}")
    public void TapOnFilter(String filterBy) {
        mapsAndATMsPage.btnFilterSelected.click();
    }

    @Then("Show add cash from a store screen")
    public void ShowAddCashFromAStoreScreen() {
        addCashStore = new AddCashStore();
    }

    @When("tap on Barcode button")
    public void tapOnBarcodebutton() {
        mapsAndATMsPage.btnGetBarCode.click();
    }

    @When("Select {string} on the store list")
    public void SelectOnTheStoreList(String store) {
        addCashStore.SelectStore(store);
    }

    @When("tap on the Generate Code button")
    public void tapOntheGenerateCodebutton() {
        addCashStore.btnGenerateBarCode.click();
    }

    @Then("Barcode screen is displayed")
    public void BarcodeScreenisDisplayed() {
        BaseUtils.waitUntilElementisPresent(addCashStore.imgBarCode);
    }

    @When("Select Create Code button")
    public void SelectCreateCodebutton() {
        addCashStore.btnCreateCode.click();
    }

    @Then("Create custom barcode alert is displayed")
    public void CreateCustomBarcodeAlertisDisplayed() {
        addCashStore.validateCustomBarcode();
    }
}
