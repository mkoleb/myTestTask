package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsListPage {

    private WebDriver driver;
    private final String filterApple = "filter_producer_69";
    private final String IDiphone = "catalog_title_block";
    private By appleGoodsInList1 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[2]/div[1]/div/div[1]/div[2]/div[4]/a");
    private By appleGoodsInList2 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[3]/div[1]/div/div[1]/div[2]/div[4]/a");
    private By appleGoodsInList3 = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[4]/div[1]/div/div[1]/div[2]/div[4]/a");

    public GoodsListPage(WebDriver driver) {this.driver = driver;}

    //@Step
    public void titleIsCorrect(){ driver.getTitle().compareToIgnoreCase("Мобильные телефоны Apple"); }

    //@Step
    public void waitForText() {WebElement webelement = (new WebDriverWait(driver, 30))
            .until(ExpectedConditions.presenceOfElementLocated(By.id(IDiphone)));
        webelement.click();
    }

    public void filterIsPresented(){
        if (driver.findElement(By.id(filterApple)).isDisplayed())
        {
            System.out.println("Filter is presented");
        } else {
            System.out.println("Filter is not presented");
        }
    }

    //@Step
    public void appleGoodsPresenceInList(){
        appleGoodsInList1.toString().contains("%iPhone%");
        System.out.println("1 cont");
        appleGoodsInList2.toString().contains("%iPhone%");
        System.out.println("2 cont");
        appleGoodsInList3.toString().contains("%iPhone%");
        System.out.println("3 cont");
    }


}
