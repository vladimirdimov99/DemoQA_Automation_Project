package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class InteractionsMenu {
    @Test
    public void test4() throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        Duration timeout = Duration.ofSeconds(3);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Book Store Application']")));

        driver.findElement(By.xpath("//*[text()='Interactions']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0, document.body.scrollHeight)");
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")));
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")).click();
    }
}
