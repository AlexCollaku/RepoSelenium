package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

    }

    /**
     * 1. Launch facebook.com
     * 2. verify your gender radio-button is not selected
     * 3. if your gender radio-button is not selected; then select the same
     * 4. verify the gender radio-button is now selected
     *
     */
    @Test
    public void verifyRadioButton() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        By maleButton = By.xpath("//input[@type='radio' and @value='2']");
        WebElement maleRadio = driver.findElement(maleButton);

        boolean isMaleSelected = maleRadio.isSelected();

        Assert.assertFalse(isMaleSelected, "Male radio button is default selected");

        if(!isMaleSelected) {
            maleRadio.click();
        }

        isMaleSelected = maleRadio.isSelected();

        Assert.assertTrue(isMaleSelected, "Male radio button is now selected");

        driver.close();

    }

    // 1. find locator
    //By monthDropdownLocator = By.id("month");
    // 2. find dropdown web-element
    //WebElement monthDropdown = driver.findElement(monthDropdownLocator);
    // 3. Create object of Select Class and provide dropdownWebElement as input to Constructor.
   // Select month = new Select(monthDropdown);
    // 4. use Select object to pick any value.
       // month.selectByVisibleText("May");
    // month.selectByValue("9");
    // month.selectByIndex(4);
       // month.selectByVisibleText("Feb");

    @Test
    public void dropdowns() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        By monthDropdownLocator = By.id("month");
        WebElement mothDropdown = driver.findElement(monthDropdownLocator);

        Select month = new Select(mothDropdown);
        month.selectByVisibleText("May");

        By dateDropdownLocator = By.id("day");
        WebElement dateDropdown = driver.findElement(dateDropdownLocator);

        Select date = new Select(dateDropdown);
        date.selectByIndex(20);

        By yearDropdownLocator = By.id("year");
        WebElement yearDropdown = driver.findElement(yearDropdownLocator);

        Select year = new Select(yearDropdown);
        year.selectByValue("2020");


    }


}
