package wiley.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(BaseTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest implements TestWatcher {

  public static WebDriver driver;
  protected int DRIVERWAIT = 5;
  protected static String baseUrl = "https://www.wiley.com";

  @AfterAll
  public void tearDownWebDriver() {
    if (driver != null) {
      driver.quit();
    }
  }

  @BeforeAll
  public void beforeTest() throws IOException {
    if (FileUtils.getFile("./target/screenshots/").canRead()) {
      FileUtils.forceDelete(new File("./target/screenshots/"));
    }

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(DRIVERWAIT, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }

  @Override
  public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
  }

  @Override
  public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
  }

  @Override
  public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
    try {
      takeScreenshot(extensionContext.getTestMethod().get().getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void testSuccessful(ExtensionContext extensionContext) {
  }

  private void takeScreenshot(String testInfo) throws IOException {
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    Files.createDirectories(Paths.get("./target/screenshots"));
    FileUtils.copyFile(scrFile, new File("./target/screenshots/" + testInfo + ".png"));
  }
}
