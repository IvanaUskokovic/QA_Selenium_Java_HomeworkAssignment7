package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void userCanAddDataToTable(){


        webTablesPage.clickOnAddButton();
        Assert.assertTrue(webTablesPage.getRegistrationForm().isDisplayed());
        String firstName = excelReader.getStringData("RegistrationForm",1,0);
        String lastName = excelReader.getStringData("RegistrationForm",1,1);
        String email =  String.valueOf(excelReader.getStringData("RegistrationForm",1,2));
        String age = String.valueOf(excelReader.getStringData("RegistrationForm",1,3));
        String department = excelReader.getStringData("RegistrationForm",1,5);
        String salary = String.valueOf(excelReader.getIntegerData("RegistrationForm",1,4));

        webTablesPage.inputFirstName(firstName);
        webTablesPage.inputLastName(lastName);
        webTablesPage.inputEmail(email);
        webTablesPage.inputAge(age);
        webTablesPage.inputDepartment(department);
        webTablesPage.inputSalary(salary);
        webTablesPage.clickOnSubmitButton();

    }
    @Test
    public void userCanAddDataToTableExcel()  {
    for (int i =1; i<excelReader.getLastRow("RegistrationForm"); i++ ) {
    webTablesPage.clickOnAddButton();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
    Assert.assertTrue(webTablesPage.getRegistrationForm().isDisplayed());
    String firstName = excelReader.getStringData("RegistrationForm", i, 0);
    String lastName = excelReader.getStringData("RegistrationForm", i, 1);
    String email = String.valueOf(excelReader.getStringData("RegistrationForm", i, 2));
    String age = String.valueOf(excelReader.getStringData("RegistrationForm", i, 3));
    String department = excelReader.getStringData("RegistrationForm", i, 5);
    String salary = String.valueOf(excelReader.getIntegerData("RegistrationForm", i, 4));

    webTablesPage.inputFirstName(firstName);
    webTablesPage.inputLastName(lastName);
    webTablesPage.inputEmail(email);
    webTablesPage.inputAge(age);
    webTablesPage.inputDepartment(department);
    webTablesPage.inputSalary(salary);
    webTablesPage.clickOnSubmitButton();
}
    }



}
