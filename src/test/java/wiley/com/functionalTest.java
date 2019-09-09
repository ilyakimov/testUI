package wiley.com;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    home.searchByNameThroughEnter("Java");
  }

  @DisplayName("Проверка работы поиска")
  @Test
  public void C() throws InterruptedException {
    String name = "Java";
    PageHome home = new PageHome(driver);
    home.searchByNameThroughClickBtn(name);
    assertEquals(driver.findElements(By.xpath("//section[@class='product-item']//span[@class='search-highlight'][text()='"+name+"']")).size(), 10);
    List<WebElement> myResult = driver.findElements(By.xpath("//div[@class='products-list']//section[@class='product-item'][1]//div[@id='tabContentStyle']//button[@class='small-button add-to-cart-button js-add-to-cart']"));
    int countAddToCart = myResult.size();
    System.out.println(countAddToCart);
 //   assertTrue(home.seeBtn(name));

  // Add to cart
  //  "//div[@class='products-list']//section[@class='product-item'][1]//div[@id='tabContentStyle']//button[@class='small-button add-to-cart-button js-add-to-cart']"

  //View on Wiley Online Library
    // "//div[@class='products-list']//section[@class='product-item'][6]//div[@id='tabContentStyle']//a[@class='small-button learn-more-button']"
  }

}
