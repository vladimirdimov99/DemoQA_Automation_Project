package Tests;

import Pages.ElementsMenu;
import utils.LoadTheDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestsElementsMenu extends LoadTheDriver {

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
    public void goToElementsMenu() {
        ElementsMenu elementsMenu = new ElementsMenu();
        elementsMenu.goToElements();
        String title = getDriver().getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/elements");
    }

    @Test(priority = 3)
    public void goToTextBoxAndEnterCredentialsAndClickSubmitButton() {
        ElementsMenu elementsMenu = new ElementsMenu();
        elementsMenu.goToTextBox();
        String title = getDriver().getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/text-box");
        elementsMenu.enterCredentials();
        elementsMenu.clickSubmitButtonAndCheckEmail();
    }

    @AfterTest
    public void closeDemoPage() {
        quitTheDriver();
    }
}
