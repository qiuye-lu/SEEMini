package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class TestAddPage {
    private static WebDriver driver;
    //private static String serverBaseURL= "http://localhost:8090";
    private static String serverBaseURL= System.getProperty("serverBaseURL");
    private static String webpageURI= "/";

    @BeforeTest
    public static void configureDriver() throws MalformedURLException{
    
	final ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--headless");
	chromeOptions.addArguments("--no-sandbox");
	chromeOptions.addArguments("--disable-dev-shm-usage");
	chromeOptions.addArguments("--window-size=1200x600");

	chromeOptions.setBinary("/usr/bin/google-chrome");
	DesiredCapabilities capability = DesiredCapabilities.chrome();
	capability.setBrowserName("chrome");
	capability.setPlatform(Platform.LINUX);

	capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

	driver = new RemoteWebDriver(new URL("http://selenium__standalone-chrome:4444/wd/hub"), capability);
    }

    @Test
    public static void testAddition() throws InterruptedException {
        int op1 = 1;
        int op2 = 2;
        int expresult = op1 + op2;
        driver.get(serverBaseURL+webpageURI);
        Thread.sleep(1000);
        String expectedString= "You have reached some content here. Congratulations!";
        driver.findElement(By.id("op1")).sendKeys(String.valueOf(op1));
        driver.findElement(By.id("op2")).sendKeys(String.valueOf(op2));
        driver.findElement(By.id("submitBtn")).click();
        Thread.sleep(1000);
        String result = driver.findElement(By.id("output")).getAttribute("value");
        Assert.assertEquals(String.valueOf(expresult), result);
        Thread.sleep(1000);
    }


    @AfterSuite
    public static void closeDriver() {
        driver.quit();
    }

}
