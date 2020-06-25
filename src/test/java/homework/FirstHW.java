package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstHW {

    /**
     * 1. Log in to Facebook
     * 2. Fill bellow data in Sign Up form
     *      First name
     *      Last name
     *      Email-address
     *      Password(s)
     *      Click Sign Up button
     * 3. Verify Error msg : "Please choose a gender. You can change who can see this later."
     */

    @Test
    public void verifyErrorMsg() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        By firstName = By.xpath("//input[contains(@aria-label, 'First n')]");
        By lastName = By.xpath("//input[contains(@aria-label, 'Last n') and @type='text']");
        By emailAddress = By.xpath("//input[starts-with(@aria-label, 'Mobile num') and @type='text']");
        By password = By.xpath("//input[starts-with(@autocomplete, 'new-pass') or contains(@data-type, 'pass')]");
        By signUp = By.name("websubmit");
        By reEnterEmail = By.xpath("//input[contains(@aria-label, 'Re-enter')]");
        By errorMsg = By.xpath("//div[contains(text(), 'Please choose')]");

        driver.findElement(firstName).sendKeys("FIRSTNAME");
        driver.findElement(lastName).sendKeys("LASTNAME");
        driver.findElement(emailAddress).sendKeys("Firstname@gamil.com");
        driver.findElement(reEnterEmail).sendKeys("Firstname@gamil.com");
        driver.findElement(password).sendKeys("lastname12345");
        driver.findElement(signUp).click();
        WebElement errorMsg1 = driver.findElement(errorMsg);
        errorMsg1.getText();

        String actualMsg = errorMsg1.getText();
        String expectedMsg = "Please choose a gender. You can change who can see this later.";

        Assert.assertEquals(actualMsg, expectedMsg);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();

    }

    /**
     * 1. Go to darksky.net
     * 2. Verify Feels-Like-temp value is in between Low-temp and High-temp
     *
     *
     */

    @Test
    public void verifyTemp() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");

        By feelsLike = By.xpath("//span[contains(@class, 'feels-like')]");
        By lowTemp = By.xpath("//span[contains(@class, 'low-temp')]");
        By highTemp = By.xpath("//span[contains(@class, 'high-temp')]");

        System.out.println("Feels-Like: " + driver.findElement(feelsLike).getText());
        System.out.println("Low-Temp: " + driver.findElement(lowTemp).getText());
        System.out.println("High-Temp: " + driver.findElement(highTemp).getText());

        String feelsLike1 = driver.findElement(feelsLike).getText();

        String tempfeels = "77˚";

        int temp = Integer.valueOf(feelsLike1);
        System.out.println(temp);




    }


}
