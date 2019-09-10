package wiley.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import wiley.com.Pages.PageEducation;
import wiley.com.Pages.PageHome;

public class functionalTest extends BaseTest {

  @DisplayName("Отображение пукнтов в разделе Who We Serve")
  @Test
  public void CheckItemsWhoWeServe() {
    PageHome home = new PageHome(driver);
    home.btnWHOWESERVE.click();
    home.seeAllBtnMenuWHOWESERVE();
  }

  @DisplayName("Проверка работы поиска через Enter")
  @Test
  public void CheckSearchFunctionalityThroughEnter(){
    PageHome home = new PageHome(driver);
    home.searchByNameThroughEnter("Java");
  }

  @DisplayName("Проверка работы поиска через Кнопку, " +
                "Отображение 10 продуктов на странице, " +
                "Отображаение хотя бы одной из кнопок AddToCart и View on Wiley Online Library у продукта")
  @Test
  public void CheckSearchFunctionalityThroughClickBtn(){
    String name = "Java";
    PageHome home = new PageHome(driver);
    home.searchByNameThroughClickBtn(name);
    assertEquals(driver.findElements(By.xpath("//section[@class='product-item']//span[@class='search-highlight'][text()='"+name+"']")).size(), 10);
    assertTrue(home.seeProductButton(name));
  }

  @DisplayName("Проверка отображения в меню 13 разделов бокового меню Subjects")
  @Test
  public void CheckItemsSidePanelSubjects () {
    PageHome home = new PageHome(driver);
    PageEducation education = new PageEducation(driver);
    Actions act = new Actions(driver);
    act.moveToElement(home.btnSUBJECTS).build().perform();
    home.btnEducation.click();
    assertTrue(driver.getTitle().contains("Education | Subjects | Wiley"));
    assertEquals(driver.findElements(By.xpath(education.sidePanelSubjects)).size(), 13);
    education.seeItemsAreDisplayedUnderSubjects();
  }
}
