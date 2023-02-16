package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(AndroidDriver driver) {
        super(driver);
    }
    @AndroidFindBy (id= "com.androidsample.generalstore:id/nameField")
    WebElement nameField;
    @AndroidFindBy (id= "com.androidsample.generalstore:id/radioFemale")
    WebElement femaleRadioBtn;
    @AndroidFindBy (id= "com.androidsample.generalstore:id/radioMale")
    WebElement maleRadioBtn;
    @AndroidFindBy (id= "com.androidsample.generalstore:id/btnLetsShop")
    WebElement letsShopBtn;

    public void enterName(String name){
        typeElement(nameField, name);
    }

    public void selectCountry(String countryName) {
        WebElement country = driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"" + countryName + "\"))"));
        country.click();
    }

    public void selectGender(String gender){
        if (gender == "Male"){
            tapElement(maleRadioBtn);
        } else {
            tapElement(femaleRadioBtn);
        }
    }

    public void tapLetsShop(){
        tapElement(letsShopBtn);
    }
}
