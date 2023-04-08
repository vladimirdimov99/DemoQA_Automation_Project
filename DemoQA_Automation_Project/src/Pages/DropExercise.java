package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DropExercise {
    @Test
    public void test3() throws IOException, InterruptedException {

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

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.moveToElement(drag);
        actions.clickAndHold(drag);
        actions.dragAndDrop(drag, drop).perform();

        String droppedOrNot = drop.getText();

        if (droppedOrNot.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
        Thread.sleep(2000);
        WebElement logoImage = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        Screenshot screen = new AShot().takeScreenshot(driver, logoImage);
        ImageIO.write(screen.getImage(), "png", new File("C://Users/Vladimir/Desktop/screenshots/Ashot.png"));

        driver.quit();
    }
}
