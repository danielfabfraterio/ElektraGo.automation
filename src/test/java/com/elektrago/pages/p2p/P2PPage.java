package com.elektrago.pages.p2p;

import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P2PPage {


    public P2PPage(){
                PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);

    }
    
}
