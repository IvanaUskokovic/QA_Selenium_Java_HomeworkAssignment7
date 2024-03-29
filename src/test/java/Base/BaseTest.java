package Base;

import Pages.WebTablesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
  public WebDriver driver;
  public WebDriverWait wait;
  public WebTablesPage webTablesPage;
  public ExcelReader excelReader;


  @BeforeClass
  public void setUp() throws IOException {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      webTablesPage = new WebTablesPage(driver);
      excelReader = new ExcelReader("RegistrationForm.xlsx");
  }

  @AfterClass
    public void tearDown(){
      driver.manage().deleteAllCookies();
      driver.quit();
  }













}
