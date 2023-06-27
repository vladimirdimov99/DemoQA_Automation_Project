package Tests;

import Pages.LoadDemoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestsAlertsMenu {

    WebDriver driver;
    Duration timeout = Duration.ofSeconds(3);
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void LoadTheDemoPage() {
        driver = new ChromeDriver();
        new LoadDemoPage().LoadPage(driver);
    }

    @Test(priority = 1)
    public void checkTitleAfterLoadingTheDemoPage() {
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/");
    }

    @Test(priority = 2)
    public void goToAlertsMenu() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts, Frame & Windows']")));
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
    }

    @Test(priority = 3)
    public void goToNestedFrames() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")));
        driver.findElement((By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"))).click();
    }

    @Test(priority = 4)
    public void switchFrames() {
        WebElement parentIframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(parentIframe);

        driver.switchTo().frame(0);

        String childIframe = driver.findElement(By.xpath("//p")).getText();
        softAssert.assertNotNull(childIframe);
        softAssert.assertEquals(childIframe, "Child Iframe");
    }

    @AfterTest
    public void closeDemoPage() {
        driver.quit();
    }
}
