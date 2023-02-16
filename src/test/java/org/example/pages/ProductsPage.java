package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }
    @AndroidFindBy(id= "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement cartBtn;
    public void selectProduct(String productName){
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"" + productName + "\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + productName + "\"]/..//*[@text=\"ADD TO CART\"]")).click();
    }
    public void tapCart(){
        tapElement(cartBtn);
    }
}
