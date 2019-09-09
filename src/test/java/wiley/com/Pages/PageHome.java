package wiley.com.Pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends PageObject {

  @FindBy(xpath = "//a[text()[contains(.,'WHO WE SERVE')]]")
  public WebElement btnWHOWESERVE;

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

  @FindBy(xpath = "//form[contains(@name, 'search_form_comp')]//aside")
  public WebElement asideSearchAutocomplete;

  @FindBy(xpath = "//div[@class='search-result-tabs-wrapper']")
  public WebElement divSearchResult;

  @FindBy(xpath = "//button[@class='glyphicon glyphicon-search']")
  public WebElement btnSearch;

  public PageHome(WebDriver driver) {
    super(driver);
  }

  public void seeAllBtnMenuWHOWESERVE(){
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

  public void searchByNameThroughEnter(String name){
    inputSearch.sendKeys(deleteString + name);
    // Отображение области waitForElementPresense(asideSearchAutocomplete);
    inputSearch.sendKeys(Keys.ENTER);
    seeSearchResult(name);
  }

  public void searchByNameThroughClickBtn(String name){
    inputSearch.sendKeys(deleteString + name);
    // Отображение области waitForElementPresense(asideSearchAutocomplete);
    btnSearch.click();
    seeSearchResult(name);
  }

  public void seeSearchResult(String name){
    waitForElementPresense(divSearchResult);
    getWhenVisible(By.xpath("//section[@class='product-item']//span[@class='search-highlight'][text()='"+name+"']"));
  }

  public boolean seeBtn(String name){
    int countProduct = driver.findElements(By.xpath("//section[@class='product-item']//span[@class='search-highlight'][text()='"+name+"']")).size();
  //  for (int i = 1; i < countProduct; i++){
    List<WebElement> myResult = driver.findElements(By.xpath("//button[@type='submit']"));
    int countAddToCart = myResult.size();
  //  int countAddToCart = 0;
  //  countAddToCart = driver.findElements(By.xpath("//form")).size();

      /*
      WebElement btn2 = driver.findElement(By.xpath(
          "//div[@class='products-list']//section[@class='product-item'][" + i
              + "]//div[@id='tabContentStyle']//a[@class='small-button learn-more-button']"));
*/
  //  }
  //  int a = btn.getSize();
    // Add to cart
    //  "//div[@class='products-list']//section[@class='product-item'][1]//div[@id='tabContentStyle']//button[@class='small-button add-to-cart-button js-add-to-cart']"
    System.out.println(countAddToCart);
    //View on Wiley Online Library
    // "//div[@class='products-list']//section[@class='product-item'][6]//div[@id='tabContentStyle']//a[@class='small-button learn-more-button']"
    boolean m = (countProduct == 1);
    if (m==true) {
      return true;
    } else {
      return false;
    }
  }
}
