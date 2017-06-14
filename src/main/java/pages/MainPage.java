package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage {

    private WebDriver driver;

    private final String URL = "http://rozetka.com.ua/";
    private final String searchQuery = "iphone";
    private By searchFieldName = By.name("text");
    private By searchButtonName = By.name("rz-search-button");

    public MainPage(WebDriver driver) {this.driver = driver;}

    public void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Step("Fill in the searsh fields by some query")
    public void fillTheSearchField(){ driver.findElement(searchFieldName).sendKeys(searchQuery); }

    @Step("Click on search button after adding the query")
    public void clickSearchButton(){ driver.findElement(searchButtonName).click(); }

}
