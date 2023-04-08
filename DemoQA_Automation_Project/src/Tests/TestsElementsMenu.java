package Tests;

import Pages.ElementsMenu;
import Pages.LoadDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestsElementsMenu {
    WebDriver driver;

    @BeforeTest
    public void LoadTheDemoPage() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        new LoadDemoPage().LoadPage(driver);
    }

    @Test(priority = 1)
    public void checkTitleAfterLoadingTheDemoPage() {
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/");
    }

    @Test(priority = 2)
    public void goToElementsMenu() {
        ElementsMenu elementsMenu = new ElementsMenu(driver);
        elementsMenu.goToElements();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/elements");
    }

    @Test(priority = 3)
    public void goToTextBoxAndEnterCredentialsAndClickSubmitButton() {
        ElementsMenu elementsMenu = new ElementsMenu(driver);
        elementsMenu.goToTextBox();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/text-box");
        elementsMenu.enterCredentials();
        elementsMenu.clickSubmitButtonAndCheckEmail();
    }

    @AfterTest
    public void closeDemoPage() {
        driver.quit();
    }
}
