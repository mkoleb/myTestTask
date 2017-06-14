import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchQueryGoodsListPage;
import pages.ShoppingCartPage;
import ru.yandex.qatools.allure.annotations.Title;

public class SearchFieldValidation {

    WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public void beforeTest(){
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
    }

    @Title("Проверка работы поиска")
    @Test
    public void openDestination(){
        MainPage mainPage = new MainPage(driver);
        SearchQueryGoodsListPage searchQueryGoodsListPage = new SearchQueryGoodsListPage(driver);

        mainPage.openPage();
        mainPage.fillTheSearchField();
        mainPage.clickSearchButton();
        searchQueryGoodsListPage.waitForText();
        searchQueryGoodsListPage.titleIsCorrect();
        searchQueryGoodsListPage.appleFilterIsPresented();
        searchQueryGoodsListPage.appleGoodsPresenceInList();
    }

    @Title("Выбор товара из результатов поиска (первого в списке результатов поиска)")
    @Test
    public void goodsPage(){
        MainPage mainPage = new MainPage(driver);
        SearchQueryGoodsListPage searchQueryGoodsListPage = new SearchQueryGoodsListPage(driver);
        ProductPage productPage = new ProductPage(driver);

        mainPage.openPage();
        mainPage.fillTheSearchField();
        mainPage.clickSearchButton();
        searchQueryGoodsListPage.waitForText();
        searchQueryGoodsListPage.chooseFirstProductInList();
        productPage.isItAProductPage();
        productPage.isThereAPhoto();
        productPage.isThereAProductReview();
    }

    @Title("Добавление товара в корзину")
    @Test
    public void addingGoodsToShoppingCart(){
        MainPage mainPage = new MainPage(driver);
        SearchQueryGoodsListPage searchQueryGoodsListPage = new SearchQueryGoodsListPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        mainPage.openPage();
        mainPage.fillTheSearchField();
        mainPage.clickSearchButton();
        searchQueryGoodsListPage.waitForText();
        searchQueryGoodsListPage.buySomeProduct();
        shoppingCartPage.popUpAppearenceWhenBuying();
        shoppingCartPage.closeCurrentPopUp();
        shoppingCartPage.wasTheProductAddedToShoppingCart();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
