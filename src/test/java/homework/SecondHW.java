package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.SortedMap;

public class SecondHW {

    /**
     * Homework 1:
     * 1. Launch Darksky
     * 2. Go to DarkSy API Homepage
     * 3. Click on 'blog Past' link
     * 4. Verify Blog page title is 'Dark Sky Blog'
     * 5. Verify Page Banner Text is SAME as Tile Header-Text (Dark Sky Has a New Home).
     * 6. Verify the Tile-Date is SAME as Blog Date
     * 7. Go Back and Verify user lands on Dark Sky API HomePage
     */

    @Test
    public void verifyHomePageDarksky() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");

        By darkskyApiHomepage = By.xpath("//a[contains(text(), 'Dark Sky')]");
        WebElement darkskyApi = driver.findElement(darkskyApiHomepage);
        darkskyApi.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By blogPostButton = By.xpath("//a[text()='blog post']");
        WebElement blogPost = driver.findElement(blogPostButton);
        blogPost.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Dark Sky Blog";

        //Assert.assertEquals(actualPageTitle, expectedPageTitle);


        By pageBannerText = By.xpath("//a[text()='Dark Sky Has a New Home']");
        WebElement pageBanner = driver.findElement(pageBannerText);
        String pageText = pageBanner.getText();

        By tileHeaderText = By.xpath("//p[starts-with(text(), 'Dark Sky Has')]");
        WebElement tileHeader = driver.findElement(tileHeaderText);
        String tileText = tileHeader.getText();

        Assert.assertEquals(pageText, tileText);

        By tileDateLocator = By.xpath("//p[@class='post_link_date']");
        WebElement tileDate = driver.findElement(tileDateLocator);
        String tileDateText = tileDate.getText();

        By blogDateLocator = By.xpath("//time[@itemprop='datePublished']");
        WebElement blogDate = driver.findElement(blogDateLocator);
        String blogDateText = blogDate.getText();

        Assert.assertEquals(tileDateText, blogDateText);

        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://darksky.net/dev";

        Assert.assertEquals(actualUrl, expectedUrl);


    }



    /**
     * Homepage 2:
     * Sign Up Flow:
     * Enter data in all fields as per your wish but use emailAddress as given below.
     * Verify user get "Please enter a valid mobile number or email address." for below email addresses:
     * 1. test####
     * 2. %%winvalied$$$
     * 3. %%$$emailAddress.co^^
     */

    @Test
    public void verifyErrorMsgForEmailaddresses() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.name("firstname")).sendKeys("Bisha");
        driver.findElement(By.name("lastname")).sendKeys("Al");

        String[] array = {"test####", "%%winvalied$$$", "%%$$emailAddress.co^^"};

        for (int i = 0; i < array.length; i++) {
            driver.findElement(By.name("reg_email__")).sendKeys(array[i]);
            break;
        }


//        By.xpath("//div[text()='Mobile number or email']/following-sibling::input[@name='reg_email__']");
//        String mobileOrEmailAddress = "Mobile number or email";
//        String mobileOrEmailXpath = "//div[text()='" + mobileOrEmailAddress + "']/following-sibling::input[@name='reg_email__']";
//        By mobileOrEmailLocater = By.xpath(mobileOrEmailXpath);

        driver.findElement(By.id("password_step_input")).sendKeys("bisha12345678910");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select month = new Select(monthDropdown);
        month.selectByVisibleText("May");

        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select day = new Select(dayDropdown);
        day.selectByIndex(20);

        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select year = new Select(yearDropdown);
        year.selectByValue("1988");

        By genderLocator = By.xpath("//input[@value='2']/following-sibling::label[@class='_58mt']");
        driver.findElement(genderLocator).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //By signUpLocator = By.xpath("//button[@name='websubmit']/following-sibling::span[contains(@class, 'hidden_elem')]");

        WebElement signUpButtonn = driver.findElement(By.name("websubmit"));
        signUpButtonn.click();

//        By errorTextLocator = By.xpath("//div[text()='Please enter a valid mobile number or email address.']");
//        WebElement errorText = driver.findElement(errorTextLocator);
//
//        String actualText = errorText.getText();
//        String expectedText = "Please enter a valid mobile number or email address.";
//
//        Assert.assertEquals(actualText, expectedText);


    }
}
