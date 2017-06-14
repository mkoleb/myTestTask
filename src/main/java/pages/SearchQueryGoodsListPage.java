package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchQueryGoodsListPage {

    private WebDriver driver;
    private final String filterApple = "filter_producer_69";
    private final String IDiphone = "catalog_title_block";
    private final String photoID = "base_image";
    private final String productNameLocator = "topurchasesfromcatalog";
    private final String shoppingCartPopUp = "//*[@id=\"cart-popup\"]/div[2]/div[1]/h2";
    private final String chooseFirstProductInList = "//*[@id=\"catalog_goods_block\"]/div/div[1]/div[1]/div/div[1]/div[2]/div[4]/a";
    private By appleGoodsInList1 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[2]/div[1]/div/div[1]/div[2]/div[4]/a");
    private By appleGoodsInList2 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[3]/div[1]/div/div[1]/div[2]/div[4]/a");
    private By appleGoodsInList3 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[4]/div[1]/div/div[1]/div[2]/div[4]/a");

    public SearchQueryGoodsListPage(WebDriver driver) {this.driver = driver;}

    @Step("Is the title of the redirected page correct")
    public void titleIsCorrect(){ driver.getTitle().compareToIgnoreCase("Мобильные телефоны Apple"); }

    @Step("Waiting for appearence of the list of products")
    public void waitForText() {WebElement webelement = (new WebDriverWait(driver, 30))
            .until(ExpectedConditions.presenceOfElementLocated(By.id(IDiphone)));
        webelement.click();
    }

    @Step("Cheking whether the right filter is presented")
    public void appleFilterIsPresented(){
        if (driver.findElement(By.id(filterApple)).isDisplayed())
        {
            System.out.println("Filter is presented");
        } else {
            System.out.println("Filter is not presented");
        }
    }

    @Step("Cheking for correct displaying of goods in list according to our filter")
    public void appleGoodsPresenceInList(){
        appleGoodsInList1.toString().contains("%iPhone%");
        appleGoodsInList2.toString().contains("%iPhone%");
        appleGoodsInList3.toString().contains("%iPhone%");
    }

    @Step("Choosing the first product in the list")
    public void chooseFirstProductInList(){
        driver.findElement(By.xpath(chooseFirstProductInList)).click();
        WebElement webelement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(photoID)));
    }

    @Step("Buying product")
    public void buySomeProduct(){
        driver.findElement(By.name(productNameLocator)).click();
        WebElement webelement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(shoppingCartPopUp)));
    }
}
