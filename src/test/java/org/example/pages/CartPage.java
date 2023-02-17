package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends BasePage{
    public CartPage(AndroidDriver driver) {
        super(driver);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    WebElement productAdded;

    public void validateProduct(String productName){
        String addedProductName = productAdded.getText();
        Assert.assertEquals(addedProductName,productName);
    }

}
