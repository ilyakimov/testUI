package wiley.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiley.com.Pages.PageHome;

public class functionalTest extends BaseTest {

  @DisplayName("Отображение пукнтов в разделе Who We Serve")
  @Test
  public void CheckItemsWhoWeServe() {
    PageHome home = new PageHome(driver);
    home.btnWHOWESERVE.click();
    home.seeAllBtnMenuWHOWESERVE();
  }

  @DisplayName("Проверка работы поиска")
  @Test
  public void CheckSearchFunctionality() {
    PageHome home = new PageHome(driver);
    home.searchByName("Programmer Practice Tests");
  }
}
