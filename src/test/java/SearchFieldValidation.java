import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchQueryGoodsListPage;
import pages.MainPage;
import pages.ShoppingCartPage;

public class SearchFieldValidation {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
    }

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
        System.out.println("it is product page");
        productPage.isThereAPhoto();
        System.out.println("photo");
        productPage.isThereAProductReview();
        System.out.println("passed");
    }

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
