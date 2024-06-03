package qtriptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPage extends Browser {

    
    public void validate_loginpage() throws InterruptedException {
        Thread.sleep(1000);
        By welcomeMessageLocator = By.xpath("//h1[text()='Welcome to QTrip']");
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageLocator));

        if (welcomeMessage.isDisplayed()) {
            System.out.println("successful login");
        } else {
            System.out.println("page are in wrongside");
        }
    }

    
    public void enter_credentials(String Email, String Password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login to QTrip']")));

        WebElement email_field = driver.findElement(By.name("email"));
        email_field.sendKeys(Email);

        WebElement password_field = driver.findElement(By.name("password"));
        password_field.sendKeys(Password);

        WebElement login_to_qtrip = driver.findElement(By.xpath("//button[text()='Login to QTrip']"));
        wait.until(ExpectedConditions.visibilityOf(login_to_qtrip));
        login_to_qtrip.click();
    }
}
