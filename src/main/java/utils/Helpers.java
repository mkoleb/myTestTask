package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    private WebDriver driver;
    Integer waits = 30;

//    public void waitForVisibilityByID(String ID) {
//        WebDriverWait wait = new WebDriverWait(driver, waits);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ID)));
//    }

    public void waitForPresenceByID(String ID) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
    }

}
