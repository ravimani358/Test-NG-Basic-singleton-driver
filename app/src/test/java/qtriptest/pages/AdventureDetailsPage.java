package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AdventureDetailsPage extends Browser{
    static RemoteWebDriver driver;
    String Trans_ID;

    
    public void reservation_adventure(String customer_name, String customer_Email, String customer_Mobile){
        WebElement name = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        name.sendKeys(customer_name);

        WebElement Email = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        Email.sendKeys(customer_Email);

        WebElement Mobile = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        Mobile.sendKeys(customer_Mobile);

        WebElement reserve_button = driver.findElement(By.className("reserve-button"));
        reserve_button.click();
    }

    
    public void success_message(){
        WebElement success_message = driver.findElement(By.className("alert alert-success"));
        String log_message = success_message.getText();
        if(log_message.contains("successful")){
            System.out.println("message verified");
        }
    }

    
    public void reservation_button(){
        WebElement reservation_button = driver.findElement(By.xpath("//a[text()='Reservations']"));
        reservation_button.click();
    }

    
    public void transaction_ID(){
        WebElement transaction_No = driver.findElement(By.xpath("//tbody/tr/th"));
        Trans_ID = transaction_No.getText();
    }

    
    public void cance_reservation(){
        WebElement cancel_button = driver.findElement(By.className("cancel-button"));
        List<WebElement> all_Transaction_ID = driver.findElements(By.xpath("//tbody/tr/th"));
        
        for(WebElement Transaction_ID : all_Transaction_ID){
            String Transaction_ID_value = Transaction_ID.getText();
            if(Transaction_ID_value.equals(Trans_ID)){
                cancel_button.click();
            }else{
                System.out.println("error message");
            }

            driver.navigate().refresh();

            if(!Transaction_ID.equals(Trans_ID)){
                System.out.println("successfully cancelled");
            }


        }
    }


}