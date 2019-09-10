package wiley.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageEducation extends  PageObject {


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

  public String sidePanelSubjects = "//div[@class='side-panel']//li";

  public PageEducation(WebDriver driver) {
    super(driver);
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
