package DemoQA_Automation_Project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ElementsMenu {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    Duration timeout = Duration.ofSeconds(3);

    public ElementsMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void goToElements() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Elements']")));
        driver.findElement(By.xpath("//*[text()='Elements']")).click();
    }

    public void goToTextBox() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")));
        driver.findElement((By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"))).click();
    }

    public void enterCredentials() {
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("Vladimir Dimov");
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).sendKeys("john@gmail.com");
        driver.findElement(By.id("currentAddress")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Sofia, Students City");
        driver.findElement(By.id("permanentAddress")).click();
        driver.findElement(By.id("permanentAddress")).sendKeys("Chirpan, Mladost");
    }

    public void clickSubmitButtonAndCheckEmail() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        driver.findElement(By.id("submit")).click();
        String name = driver.findElement(By.id("userEmail")).getAttribute("value");
        String classNameOfEmailField = driver.findElement(By.id("userEmail")).getAttribute("class");
        softAssert.assertEquals(name, "john@gmail.com");
        softAssert.assertEquals(classNameOfEmailField.contains("error"), false, "Invalid Email address!!!");
    }

    public void closeDemoPage() {
        driver.quit();
    }
}
