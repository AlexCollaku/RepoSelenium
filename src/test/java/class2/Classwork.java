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
}
