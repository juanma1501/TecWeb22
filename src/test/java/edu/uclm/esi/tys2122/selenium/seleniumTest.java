package edu.uclm.esi.tys2122.selenium;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class seleniumTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("http://localhost/");
        driver.manage().window().setSize(new Dimension(1210, 1030));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/div[3]/input")).click();
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/div[3]/input")).clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/div[3]/input")).sendKeys("alonso");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/div[3]/input")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'example\']/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/div/div[2]/button/label")).click();
        js.executeScript("window.scrollTo(0,0)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /***/
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).sendKeys("1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).sendKeys("1");
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/button")).click();
        {
            WebElement element = driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        js.executeScript("window.scrollTo(0,411)");
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).sendKeys("0");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/div/input")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/oj-module/div[1]/div/div[2]/form/ol/div[2]/input")).sendKeys("2");
        driver.findElement(By.xpath("//div[@id=\'globalBody\']/oj-module/div/div/div/form/ol/button")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
