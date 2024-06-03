package qtriptest.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
    static RemoteWebDriver driver;
    static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
	public static RemoteWebDriver createDriver() throws MalformedURLException {
        singletone singleton = singletone.getInstance();
		driver = singleton.getDriver();
        return driver;
	}

    @BeforeMethod (alwaysRun = true)
    public static void launchURL() throws MalformedURLException {
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        driver.manage().window().maximize();
    }

    @BeforeTest(alwaysRun = true)
    public static WebDriverWait getWebDriverWait(){
        wait = new WebDriverWait(driver, 5);
        return wait;
    }
    


    // @AfterMethod()
    // public static void closebrowser(){
    //     driver.close();
    // }
}
