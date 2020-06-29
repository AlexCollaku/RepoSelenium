package class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Classwork {

    @Test
    public void verifyPageUrl() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //WebDriver driver2 = new FirefoxDriver();

        String url = "https://www.facebook.com/";
        driver.get(url);
        //driver.navigate().to(url);

        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://www.facebook.com/";
        //String actualPageTitle = driver.getTitle();


        Assert.assertEquals(actualPageUrl, expectedPageUrl);
        //Assert.assertTrue();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();



    }

    @Test
    public void testMethod() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //WebDriver driver2 = new FirefoxDriver();

        String url = "https://www.facebook.com/";
        driver.get(url);
        Thread.sleep(1000);

        driver.findElement(By.id("u_0_q")).sendKeys("Aleksander");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Collaku");
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Create a")).click();
        Thread.sleep(2000);


    }

    @Test
    public void testPages() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-161bde80079893c25d9c0a08feb3551-ba325c96c4470fa0e8cbb572bec70fa644e4a92e&flowName=GlifWebSignIn&flowEntry=SignUp");

        By firstName = By.name("firstName");
        By lastName = By.id("lastName");
        By userName = By.xpath("//input[@aria-label='Username']");
        By password = By.xpath("//input[contains(@aria-label, 'Passw')]");
        By confirmPass = By.xpath("//input[starts-with(@jsname, 'YP') and @aria-label='Confirm']");
        By nextButton = By.xpath("//span[text()='Next']");

        driver.findElement(firstName).sendKeys("Alex");
        driver.findElement(lastName).sendKeys("Bisha");
        driver.findElement(userName).sendKeys("alexbisha241");
        driver.findElement(password).sendKeys("124343434");
        driver.findElement(confirmPass).sendKeys("124343434");
        driver.findElement(nextButton).click();

        /**
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */



    }
}
