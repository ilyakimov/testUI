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

  @FindBy(xpath = "//form[contains(@name, 'search_form_comp')]//aside")
  public WebElement asideSearchAutocomplete;

  @FindBy(xpath = "//div[@class='search-result-tabs-wrapper']")
  public WebElement divSearchResult;

  @FindBy(xpath = "//button[@class='glyphicon glyphicon-search']")
  public WebElement btnSearch;

  @FindBy(xpath = "//li[@class='dropdown-item dropdown-submenu']/a[text()[contains(.,'Education')]]")
  public WebElement btnEducation;

  @FindBy(xpath = "//li[@class='dropdown-item dropdown-submenu']/a[text()[contains(.,'Education')]]")
  public WebElement Education;

  @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Information & Library Science')]]")
  public WebElement liInformationLibraryScience;

  @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Education & Public Policy')]]")
  public WebElement liEducationPublicPolicy;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'K-12 General')]]")
    public WebElement liK12General;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Higher Education General')]]")
    public WebElement liHigherEducationGeneral;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Vocational Technology')]]")
    public WebElement liVocationalTechnology;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Conflict Resolution & Mediation (School settings)')]]")
    public WebElement liConflictResolutionMediation;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Curriculum Tools- General')]]")
    public WebElement liCurriculumToolsGeneral;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Special Educational Needs')]]")
    public WebElement liSpecialEducationalNeeds;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Theory of Education')]]")
    public WebElement liTheoryOfEducation;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Education Special Topics')]]")
    public WebElement liEducationSpecialTopics;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Educational Research & Statistics')]]")
    public WebElement liEducationalResearchStatistics;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Literacy & Reading')]]")
    public WebElement liLiteracyReading;

    @FindBy(xpath = "//div[@class='side-panel']//a[text()[contains(.,'Classroom Management')]]")
    public WebElement liClassroomManagement;

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

  public boolean seeProductButton(String name){
    int countProduct = driver.findElements(By.xpath("//section[@class='product-item']//span[@class='search-highlight'][text()='"+name+"']")).size();
      int i = 1;
      while (i < countProduct){
          int btnAddToCart = driver.findElements(By.xpath("//div[@class='products-list']//section[@class='product-item']["+i+"]//div[@id='tabContentStyle']//button[@class='small-button add-to-cart-button js-add-to-cart']")).size();
          int btnLearnMoreButton = driver.findElements(By.xpath("//div[@class='products-list']//section[@class='product-item']["+i+"]//div[@id='tabContentStyle']//a[@class='small-button learn-more-button']")).size();
          if ((btnAddToCart >= 1) || (btnLearnMoreButton >= 1)) {
              return true;
          } else {
              return false;
          }
      }
      return false;
  }

  public void seeItemsAreDisplayedUnderSubjects(){
    liInformationLibraryScience.isDisplayed();
    liEducationPublicPolicy.isDisplayed();
    liK12General.isDisplayed();
    liHigherEducationGeneral.isDisplayed();
    liVocationalTechnology.isDisplayed();
    liConflictResolutionMediation.isDisplayed();
    liCurriculumToolsGeneral.isDisplayed();
    liSpecialEducationalNeeds.isDisplayed();
    liTheoryOfEducation.isDisplayed();
    liEducationSpecialTopics.isDisplayed();
    liEducationalResearchStatistics.isDisplayed();
    liLiteracyReading.isDisplayed();
    liClassroomManagement.isDisplayed();
  }
}
