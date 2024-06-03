package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HomePage extends Browser {

    public void successful_logout() {
        WebElement login_button = driver.findElement(By.xpath("//a[text()='Login Here']"));
        wait.until(ExpectedConditions.visibilityOf(login_button));
        if (login_button.getText().equals("Login to QTrip")) {
            System.out.println("successful login");
        }
    }


    public void Home_register_button() {
        driver.findElement(By.xpath("//a[text()='Register']")).click();
    }


    public void clear_search_field() {
        WebElement search_field = driver.findElement(By.className("hero-input"));
        search_field.clear();
    }


    public void Home_page_register_button() {
        WebElement register_button = driver.findElement(By.xpath("//a[text()='Register']"));
        wait.until(ExpectedConditions.visibilityOf(register_button));
        register_button.click();
    }


    public void logout_button() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Logout']")));
        WebElement logout = driver.findElement(By.xpath("//div[text()='Logout']"));
        logout.click();
    }

    
    public void successful_login() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Logout']")));
        WebElement Logout_button = driver.findElement(By.xpath("//div[text()='Logout']"));
        boolean status = Logout_button.isDisplayed();
        System.out.println(status);
    }

    
    public void search_city_noresult(String city_name) {
        WebElement search_box = driver.findElement(By.className("hero-input"));
        search_box.sendKeys(city_name);

        List<WebElement> search_result = driver.findElements(By.className("results"));
        for (WebElement result : search_result) {
            String result_value = result.getText();
            if (result_value.equals("No City found")) {
                System.out.println("No City found");
            } else if (result_value.equals(city_name)) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("results")));
                result.click();
            } else {
                System.out.println(result_value);
            }
        }
    }
}
