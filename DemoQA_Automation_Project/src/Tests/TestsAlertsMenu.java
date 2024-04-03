package Tests;

import utils.LoadTheDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestsAlertsMenu extends LoadTheDriver {

    Duration timeout = Duration.ofSeconds(3);
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void LoadTheDemoPage() {
        new LoadTheDriver().LoadTheWebsite(getDriver());
    }

    @Test(priority = 1)
    public void checkTitleAfterLoadingTheDemoPage() {
        String title = getDriver().getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/");
    }

    @Test(priority = 2)
    public void goToAlertsMenu() {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts, Frame & Windows']")));
        getDriver().findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
    }

    @Test(priority = 3)
    public void goToNestedFrames() {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")));
        getDriver().findElement((By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"))).click();
    }

    @Test(priority = 4)
    public void switchFrames() {
        WebElement parentIframe = getDriver().findElement(By.id("frame1"));
        getDriver().switchTo().frame(parentIframe);

        getDriver().switchTo().frame(0);

        String childIframe = getDriver().findElement(By.xpath("//p")).getText();
        softAssert.assertNotNull(childIframe);
        softAssert.assertEquals(childIframe, "Child Iframe");
    }

    @AfterTest
    public void closeDemoPage() {
        quitTheDriver();
    }
}
