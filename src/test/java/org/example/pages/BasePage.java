package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

    AndroidDriver driver;
    //Initialize Page Factory
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Base Methods
    public void getElement(WebElement element) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void tapElement(WebElement element) {
        getElement(element);
        element.click();
    }

    public void typeElement(WebElement element, String text) {
        getElement(element);
        element.clear();
        element.sendKeys(text);
    }

}
