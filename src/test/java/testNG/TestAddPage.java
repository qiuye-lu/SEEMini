package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAddPage {
    private static WebDriver driver;
    private static String serverBaseURL= "http://localhost:8090";
    private static String webpageURI= "/";

    @BeforeTest
    public static void configureDriver() {
        System.setProperty("webdriver.chrome.driver" ,  "lib/linux/chromedriver");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public static void testAddition() throws InterruptedException {
        int op1 = 1;
        int op2 = 2;
        int expresult = op1 + op2 + 1;
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
