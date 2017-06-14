package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductPage {

    private WebDriver driver;
    private final String photoID = "base_image";
    private final String reviewID = "comments";
    private final String productPageURL = "http://rozetka.com.ua/apple_iphone_5s_16gb_space_gray_me432rk_a/p6800444/";

    public ProductPage(WebDriver driver) {this.driver = driver;}

    @Step("Check whether the redirected page is correct")
    public void isItAProductPage(){
        String currentProductURL = driver.getCurrentUrl().toString();
        Assert.assertEquals(currentProductURL, productPageURL);
    }

    @Step("Presence of selected product photo")
    public void isThereAPhoto(){
        driver.findElement(By.id(photoID)).isDisplayed();
    }

    @Step("Presence of selected product reviews")
    public void isThereAProductReview(){
        driver.findElement(By.id(reviewID)).isDisplayed();
    }

}

