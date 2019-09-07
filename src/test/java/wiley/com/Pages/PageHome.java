package wiley.com.Pages;

import org.openqa.selenium.By;
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

  @FindBy(xpath = "//input[@id='js-site-search-input']")
  public WebElement inputSearch;

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

  public void searchByName(String name){
    inputSearch.sendKeys(name);
    display: none;
    display: top;
    // Отображение области
    getWhenNotVisible(By.xpath("//div[contains(@class, 'product-list-wrapper')]//a[text()[contains(.,'"+name+"')]]"));
  }
}
