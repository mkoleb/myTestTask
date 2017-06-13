import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchFieldValidation {

    WebDriver driver = new FirefoxDriver();
    MainPage mp = new MainPage(driver);



    @Test
    public void openDestination(){
        System.setProperty("webdriver.chrome.driver", "geckodriver");
            mp.openPage();
            mp.fillTheSearchField();
        //assert
    }

    @Test
    public void fillTheSearchField(){
        //System.setProperty("webdriver.chrome.driver", "geckodriver");
        mp.fillTheSearchField();
    }

}
