package DemoQA_Automation_Project.Pages;

import org.openqa.selenium.WebDriver;

public class LoadDemoPage {

    public void LoadPage(WebDriver driver) {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }
}
