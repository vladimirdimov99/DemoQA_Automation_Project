package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.LoadTheDriver;

import java.time.Duration;

public class ElementsMenu extends LoadTheDriver {

    SoftAssert softAssert = new SoftAssert();
    Duration timeout = Duration.ofSeconds(3);


    public void goToElements() {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Elements']")));
        getDriver().findElement(By.xpath("//*[text()='Elements']")).click();
    }

    public void goToTextBox() {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")));
        getDriver().findElement((By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"))).click();
    }

    public void enterCredentials() {
        getDriver().findElement(By.id("userName")).click();
        getDriver().findElement(By.id("userName")).sendKeys("Vladimir Dimov");
        getDriver().findElement(By.id("userEmail")).click();
        getDriver().findElement(By.id("userEmail")).sendKeys("john@gmail.com");
        getDriver().findElement(By.id("currentAddress")).click();
        getDriver().findElement(By.id("currentAddress")).sendKeys("Sofia, Students City");
        getDriver().findElement(By.id("permanentAddress")).click();
        getDriver().findElement(By.id("permanentAddress")).sendKeys("Chirpan, Mladost");
    }

    public void clickSubmitButtonAndCheckEmail() {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        getDriver().findElement(By.id("submit")).click();
        String name = driver.findElement(By.id("userEmail")).getAttribute("value");
        String classNameOfEmailField = getDriver().findElement(By.id("userEmail")).getAttribute("class");
        softAssert.assertEquals(name, "john@gmail.com");
        softAssert.assertEquals(classNameOfEmailField.contains("error"), false, "Invalid Email address!!!");
    }
}
