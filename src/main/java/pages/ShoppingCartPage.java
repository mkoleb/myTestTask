package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    private WebDriver driver;
    int waits = 15;

    private final String shoppingCartPopUp = "//*[@id=\"cart-popup\"]/div[2]/div[1]/h2";
    private final String closePopUp = "close";
    private final String goToshoppingCart = "cart_popup_header";
    private final String deleteFromShoppingCart = "before_delete";
    private final String ifPopUpLoginAppearsDo = "//*[@id=\"popup_signin\"]/div[1]/div[2]/div[1]/div[2]/div/a";

    public ShoppingCartPage(WebDriver driver) {this.driver = driver;}

    //@Step
    public void popUpAppearenceWhenBuying(){
        WebElement webelement = (new WebDriverWait(driver, waits))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(shoppingCartPopUp)));
    }

    //@Step
    public void closeCurrentPopUp(){
        driver.findElement(By.name(closePopUp)).click();
    }

    //@Step
    public void wasTheProductAddedToShoppingCart(){
        WebElement goToShoppingCart = (new WebDriverWait(driver, waits))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(goToshoppingCart)));
        goToShoppingCart.click();

        WebElement productSum = (new WebDriverWait(driver, waits))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(deleteFromShoppingCart)));
    }
}
