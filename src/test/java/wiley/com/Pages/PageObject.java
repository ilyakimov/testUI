package wiley.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wiley.com.BaseTest;

public class PageObject extends BaseTest {

  WebDriver driver;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitForElementPresense(WebElement element) {
    new WebDriverWait(driver, DRIVERWAIT)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public WebElement getWhenVisible(By locator) {
    WebElement element = null;
    WebDriverWait wait = new WebDriverWait(driver, DRIVERWAIT);
    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return element;
  }

  public Boolean getWhenNotVisible(By locator) {
    Boolean element = null;
    WebDriverWait wait = new WebDriverWait(driver, DRIVERWAIT);
    element = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    return element;
  }
}
