package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    String searchQuery = "iphone7";

    public MainPage(WebDriver driver)
    {this.driver = driver;}

    //@Step
    public void openPage(){
        driver.get("http://rozetka.com.ua/");
    }

    //@Step
    public void fillTheSearchField(){
        driver.findElement(By.name("text")).sendKeys(searchQuery);
    }


}
