package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.BeforeAll;
import page.MainPage;
import org.junit.Assert;


public class TestActions {
    MainPage mainPage = Selenide.page(MainPage.class);


    @BeforeAll
    static void setupAll(){
        Configuration.headless=false;
        Configuration.clickViaJs=true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Before
    public void openRegard(){
        mainPage.openRegard();

    }

    @Test
    @Description("Проверка блока сейчас актуально на главной странице")
    public void checkActualNowBlock() {
        mainPage.checkTitleActualNowBlock();
        mainPage.actualNowBlockIsVisible();
        mainPage.actualNowBlockBrandAndCateoryTitleIsVisible();
    }

    @Test
    @Description("Проверка блока хит продаж на главной странице")
    public void checkHitSellerBlock() {
        mainPage.hitSellerBlockIsVisible();
        mainPage.checkHitSellerBlockTitle();
    }

    @Test
    @Description("Проверка блока новинки на главной странице")
    public void checkNewProductsBlock() {
        mainPage.newProductsBlockIsVisible();
        mainPage.checkNewProductsBlockTitle();
    }

    @Test
    @Description("Проверка кнопок в корзину в хит продаж на главной странице ")
    public void checkBasketButtonOnHitsBlock() {
        mainPage.clickBasketButtonOnTopHits();
        int changedCounter = mainPage.getDataBasket();
        Assert.assertEquals(1,changedCounter);
    }

    @Test
    @Description("Проверка кнопок в корзину в хит продаж на главной странице ")
    public void checkBCompareButtonOnHitsBlock() {
        mainPage.clickCompareButtonOnTopHits();
        int changedCounter = mainPage.getDataCompare();
        Assert.assertEquals(1,changedCounter);
    }


//    @Test
//    @Description("Проверка кнопок в корзину в новых товарах на главной странице ")
//    public void checkBasketButtonOnNewProductsBlock(){
//        mainPage.clickBasketButtonOnNewProducts();
//        int changedCounter = mainPage.getDataBasket();
//        Assert.assertEquals(1,changedCounter);
//    }

    @Test
    @Description("Проверка кнопок в избранное в хите продаж на главной странице ")
    public void checkFavouriteButtonOnHitsBlock() {
        mainPage.clickFavouriteButtonOnTopHits();
        int changedCounter = mainPage.getDataFavourite();
        Assert.assertEquals(1,changedCounter);
    }

}