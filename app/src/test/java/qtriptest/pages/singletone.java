package qtriptest.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class singletone {
    private static singletone instance;
    private RemoteWebDriver driver;

    private singletone() throws MalformedURLException {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static synchronized singletone getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new singletone();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
