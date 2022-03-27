package page;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private final SelenideElement actualNowBlockTitle = $x("//span[contains(text(),'Сейчас актуально')]");
    private final SelenideElement actulNowBlock = $(By.className("CardActual_wrap__3L7AB"));
    private final SelenideElement actulNowBlockCard = $(By.className("Categories_categorySlide__3pVkO"));
    private final SelenideElement actualNowBlockBrandTitle = $(By.className("CardActual_title__2gDs2"));
    private final SelenideElement actualNowBlockCateoryTitle =   $(By.className("CardActual_category__17-Uv"));
    private final SelenideElement hitSellerBlock = $(By.className("homePage_hits__1qK6B"));
    private final SelenideElement hitSellerBlockTitle = $x("//h2[contains(text(),'Хиты продаж')]");
    private final SelenideElement newProductsBlock = $(By.className("homePage_new__1qIkA"));
    private final SelenideElement newProductsBlockTitle = $x("//h2[contains(text(),'Новинки')]");
    private final SelenideElement buttonBasketOnTopHits = $x("(//button[@type='button'][contains(text(),'В корзину')])[1]");
    private final SelenideElement buttonBasketOnNewProducts = $x("(//button[@type='button'][contains(text(),'В корзину')])[61]");
    private final SelenideElement basketCounterElement = $x("//div[@id='basket']");
    private final SelenideElement compareButtonOnTopHits = $x("(//button[@class='IconRectangle_wrap__183pz IconRectangle_filled__3jD4F IconRectangle_small__3jduB IconRectangle_compare__2DRI6'])[1]");
    private final SelenideElement compareCounterElement = $x("//div[@id='compare']");
    private final SelenideElement favouriteButtonOnTopHits = $x("(//button[@class='IconRectangle_wrap__183pz IconRectangle_filled__3jD4F IconRectangle_small__3jduB IconRectangle_favorite__1_K3U'])[1]");
    private final SelenideElement favouriteCounterElement = $x("//div[@id='favourite']");

    @Step("Открытие сайта")
    public void openRegard() {
        Selenide.open("https://site.regard.ru");
    }

    @Step("Переход к блоку сейчас актуально на главной странице,проверка виден ли блок")
    public void actualNowBlockIsVisible() {
        actulNowBlock.should(Condition.visible);
    }

    @Step("Проверка тайтла сейчас актуально")
    public void checkTitleActualNowBlock() {
        actualNowBlockTitle.shouldHave((text("Сейчас актуально")));
    }

    @Step("Проверка тайтлов категорий и брендов в блоке \"Сейчас актуально\" ")
    public void actualNowBlockBrandAndCateoryTitleIsVisible() {
        actualNowBlockBrandTitle.should(Condition.visible);
        actualNowBlockCateoryTitle.should(Condition.visible);
    }

    @Step("Проверка блока хит продаж на главной странице")
    public void hitSellerBlockIsVisible() {
        hitSellerBlock.should(Condition.visible);
    }

    @Step("Проверка тайтла в блоке  хит продаж на главной странице")
    public void checkHitSellerBlockTitle() {
        hitSellerBlockTitle.shouldHave((text("Хиты продаж")));
    }

    @Step("Проверка блока новинки на главной странице")
    public void newProductsBlockIsVisible() {
        newProductsBlock.should(Condition.visible);
    }

    @Step("Проверка тайтла в блоке новинки на главной странице")
    public void checkNewProductsBlockTitle() {
        newProductsBlockTitle.shouldHave((text("Новинки")));
    }

    @Step("Клик на кнопку в корзину в разделе топ хиты")
    public void clickBasketButtonOnTopHits() {
        buttonBasketOnTopHits.should(Condition.visible);
        buttonBasketOnTopHits.click();
    }

    @Step("Клик на кнопку в корзину в разделе новинки")
    public void clickBasketButtonOnNewProducts() {
        buttonBasketOnNewProducts.should(Condition.visible);
        buttonBasketOnNewProducts.click();
    }

    @Step("Клик на кнопку сравнений в разделе новинки")
    public void clickCompareButtonOnTopHits() {
        compareButtonOnTopHits.should(Condition.visible);
        compareButtonOnTopHits.click();
    }

    @Step("Клик на кнопку сравнений в разделе новинки")
    public void clickCompareButtonOnNewProducts() {
        buttonBasketOnNewProducts.should(Condition.visible);
        buttonBasketOnNewProducts.click();
    }


    @Step("Клик на кнопку избранное в разделе новинки")
    public void clickFavouriteButtonOnTopHits() {
        favouriteButtonOnTopHits.should(Condition.visible);
        favouriteButtonOnTopHits.click();
    }

    public int getDataBasket(){
        int counter = Integer.parseInt(basketCounterElement.getAttribute("data-count"));
       return counter;
    }

    public int getDataCompare(){
        int counter = Integer.parseInt(compareCounterElement.getAttribute("data-count"));
        return counter;
    }

    public int getDataFavourite(){
        int counter = Integer.parseInt(compareCounterElement.getAttribute("data-count"));
        return counter;
    }
}