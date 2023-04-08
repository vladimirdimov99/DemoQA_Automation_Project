package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AlertsMenu {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    Duration timeout = Duration.ofSeconds(3);

    public void AlertsMenu() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts, Frame & Windows']")));
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
    }

    public void NestedFrames() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")));
        driver.findElement((By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"))).click();
    }

    public void switchFrames() {
        WebElement parentIframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(parentIframe);

        driver.switchTo().frame(0);

        String childIframe = driver.findElement(By.xpath("//p")).getText();
        softAssert.assertNotNull(childIframe);
        softAssert.assertEquals(childIframe, "Child Iframe");
    }
}

