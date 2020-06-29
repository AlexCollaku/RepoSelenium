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

        By firstName = By.name("firstname");
        By lastName = By.name("lastname");
        By emailAddress = By.name("reg_email__");
        By password = By.xpath("//input[starts-with(@autocomplete, 'new-pass') or contains(@data-type, 'pass')]");
        By signUp = By.name("websubmit");
        By reEnterEmail = By.name("reg_email_confirmation__");
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
        //System.out.println(feelsLike1.substring(0, 2));
        String lowTemp1 = driver.findElement(lowTemp).getText();
        String highTemp1 = driver.findElement(highTemp).getText();

        String feelsLikeTemp = feelsLike1.substring(0, 2);
        String lowTemperature = lowTemp1.substring(0, 2);
        String highTemperature = highTemp1.substring(0, 2);

        int feelsTemper = Integer.valueOf(feelsLikeTemp);
        //int temp = Integer.parseInt(feelsLike1);
        //System.out.println(feelsTemper);

        int lowTemper = Integer.valueOf(lowTemperature);
        //System.out.println(lowTemper);

        int highTemper = Integer.valueOf(highTemperature);
        //System.out.println(highTemper);

        if(lowTemper < feelsTemper && feelsTemper < highTemper) {
            System.out.println("Feels-Like: " + feelsTemper +"˚");
        } else {
            System.out.println("Not the right temperature");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();

    }

}
