package com.elektrago.pages.gifselection;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GifSelectionPage {

    public GifSelectionPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }
    
    // Lista de todos los ImageView dentro del RecyclerView de GIFs
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.elektrago.elektrago:id/gifRecycler']//android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeCell//XCUIElementTypeImage")
    private List<WebElement> gifImages;

    /**
     * Selecciona de manera aleatoria un android.widget.ImageView de la grilla de GIFs y realiza clic sobre él.
     * Lanza una excepción si no se encuentran elementos.
     */
    public void selectRandomGif() {
        if (AppiumDriverFactory.getDevice().equalsIgnoreCase("android")) {
            if (gifImages != null && !gifImages.isEmpty()) {
                int randomIndex = new Random().nextInt(gifImages.size());
                gifImages.get(randomIndex).click();
            } else {
                throw new RuntimeException("No se encontraron elementos de imagen en la grilla de GIFs para Android.");
            }
        } else if (AppiumDriverFactory.getDevice().equalsIgnoreCase("ios")) {
            if (gifImages != null && !gifImages.isEmpty()) {
                int randomIndex = new Random().nextInt(gifImages.size());
                gifImages.get(randomIndex).click();
            } else {
                throw new RuntimeException("No se encontraron elementos de imagen en la grilla de GIFs para iOS.");
            }
        }
    }


}
