package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class RegisterPage extends Browser {

    public String lastGeneratedUserName="";
    
    public void verify_register_page() {
        WebElement register_button = driver.findElement(By.xpath("//button[text()='Register Now']"));
        wait.until(ExpectedConditions.visibilityOf(register_button));
        if (register_button.getText().equals("Register Now")) {
            System.out.println("register page");
        }
    }

    
    public void register_button() {
        WebElement Register_Now = driver.findElement(By.xpath("//button[text()='Register Now']"));
        Register_Now.click();
    }

    
    public void register_new_user(String userName, String Password, String Conform_password, boolean generateRandomUsername) throws InterruptedException {
        WebElement Email_field = driver.findElement(By.name("email"));

        
        if (generateRandomUsername == true)
        userName = userName+UUID.randomUUID().toString();
        this.lastGeneratedUserName=userName;

        Email_field.sendKeys(userName);
        WebElement password_field = driver.findElement(By.name("password"));
        password_field.sendKeys(Password);
        WebElement confirm_password_field = driver.findElement(By.name("confirmpassword"));
        confirm_password_field.sendKeys(Conform_password);

        WebElement register_button = driver.findElement(By.xpath("//button[text()='Register Now']"));
        wait.until(ExpectedConditions.elementToBeClickable(register_button));
        Thread.sleep(1000);
        register_button.click();
    }
}
