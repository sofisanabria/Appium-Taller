package org.example.tests;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductsPage;
import org.testng.annotations.Test;

public class test1 extends TestBase{


    @Test
    public void test1(){
        HomePage homePage = new HomePage(driver);
        homePage.enterName("Felipe");
        homePage.selectCountry("Austria");
        homePage.selectGender("Male");
        homePage.tapLetsShop();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectProduct("PG 3");
        productsPage.tapCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateProduct("PG 3");
    }
}
