package wiley.com.Pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends PageObject {

  @FindBy(xpath = "//a[text()[contains(.,'WHO WE SERVE')]]")
  public WebElement btnWHOWESERVE;

  @FindBy(xpath = "//a[text()[contains(.,'SUBJECTS')]]")
  public WebElement btnSUBJECTS;

  @FindBy(xpath = "//a[text()[contains(.,'Students')]]")
  public WebElement btnStudents;

  @FindBy(xpath = "//a[text()[contains(.,'Instructors')]]")
  public WebElement btnInstructors;

  @FindBy(xpath = "//a[text()[contains(.,'Book Authors')]]")
  public WebElement btnBookAuthors;

  @FindBy(xpath = "//a[text()[contains(.,'Professionals')]]")
  public WebElement btnProfessionals;

  @FindBy(xpath = "//a[text()[contains(.,'Researchers')]]")
  public WebElement btnResearchers;

  @FindBy(xpath = "//a[text()[contains(.,'Institutions')]]")
  public WebElement btnInstitutions;

  @FindBy(xpath = "//a[text()[contains(.,'Librarians')]]")
  public WebElement btnLibrarians;

  @FindBy(xpath = "//a[text()[contains(.,'Corporations')]]")
  public WebElement btnCorporations;

  @FindBy(xpath = "//a[text()[contains(.,'Societies')]]")
  public WebElement btnSocieties;

  @FindBy(xpath = "//a[text()[contains(.,'Journal Editors')]]")
  public WebElement btnJournalEditors;

  @FindBy(xpath = "//a[text()[contains(.,'Bookstores')]]")
  public WebElement btnBookstores;

  @FindBy(xpath = "//a[text()[contains(.,'Government')]]")
  public WebElement btnGovernment;

  @FindBy(xpath = "//input[@id='js-site-search-input']")
  public WebElement inputSearch;

  @FindBy(xpath = "//aside[@class='ui-autocomplete ui-front main-navigation-search-autocomplete ui-menu ui-widget ui-widget-content ps-container ps-theme-default']")
  public WebElement asideSearchAutocomplete;

  @FindBy(xpath = "//div[@class='search-result-tabs-wrapper']")
  public WebElement divSearchResult;

  @FindBy(xpath = "//button[@class='glyphicon glyphicon-search']")
  public WebElement btnSearch;

  @FindBy(xpath = "//li[@class='dropdown-item dropdown-submenu']/a[text()[contains(.,'Education')]]")
  public WebElement btnEducation;

  public PageHome(WebDriver driver) {
    super(driver);
  }

  public void seeAllBtnMenuWHOWESERVE() {
    waitForElementPresense(btnStudents);
    waitForElementPresense(btnInstructors);
    waitForElementPresense(btnBookAuthors);
    waitForElementPresense(btnProfessionals);
    waitForElementPresense(btnResearchers);
    waitForElementPresense(btnInstitutions);
    waitForElementPresense(btnLibrarians);
    waitForElementPresense(btnCorporations);
    waitForElementPresense(btnSocieties);
    waitForElementPresense(btnJournalEditors);
    waitForElementPresense(btnBookstores);
    waitForElementPresense(btnGovernment);
  }

  public void searchByNameThroughEnter(String name) {
    inputSearch.sendKeys(deleteString + name);
    waitForElementPresense(asideSearchAutocomplete);
    assertEquals(asideSearchAutocomplete.getCssValue("display"), "block");
    inputSearch.sendKeys(Keys.ENTER);
    seeSearchResult(name);
  }

  public void searchByNameThroughClickBtn(String name) {
    inputSearch.sendKeys(deleteString + name);
    btnSearch.click();
    seeSearchResult(name);
  }

  public void seeSearchResult(String name) {
    waitForElementPresense(divSearchResult);
    getWhenVisible(By.xpath(
        "//section[@class='product-item']//span[@class='search-highlight'][text()='" + name
            + "']"));
  }

  public boolean seeProductButton(String name) {
    int countProduct = driver.findElements(By.xpath(
        "//section[@class='product-item']//span[@class='search-highlight'][text()='" + name + "']"))
        .size();
    int i = 1;
    while (i < countProduct) {
      int btnAddToCart = driver.findElements(By.xpath(
          "//div[@class='products-list']//section[@class='product-item'][" + i
              + "]//div[@id='tabContentStyle']//button[@class='small-button add-to-cart-button js-add-to-cart']"))
          .size();
      int btnLearnMoreButton = driver.findElements(By.xpath(
          "//div[@class='products-list']//section[@class='product-item'][" + i
              + "]//div[@id='tabContentStyle']//a[@class='small-button learn-more-button']"))
          .size();
      if ((btnAddToCart >= 1) || (btnLearnMoreButton >= 1)) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }
}
