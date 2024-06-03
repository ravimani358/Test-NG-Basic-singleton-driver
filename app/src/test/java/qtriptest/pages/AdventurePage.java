package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdventurePage extends Browser {
    static RemoteWebDriver driver;

    
    public void filter_hours(){
        WebElement filter_Dropdown = driver.findElement(By.name("duration"));
        Select filter_drop_down = new Select(filter_Dropdown);
        filter_drop_down.selectByValue("2-6");
        List<WebElement> durations = driver.findElements(By.xpath("//h5[text()='Duration']/following-sibling::p"));

        for(WebElement durations_value :durations ){
            String duration_value = durations_value.getText();
            String[] split_duration = duration_value.split(" ");
            int duration = Integer.parseInt(split_duration[0].toString());
            if(duration>2 && duration<6){
                System.out.println("functions are working as expected");
            }else{
                System.out.println("fucntion not wokring");
            }
        }
        
    }

    
    public void filter_category(String Cycling_value){
        WebElement category_dropdown = driver.findElement(By.id("category-select"));
        Select filter_drop_down = new Select(category_dropdown);
        filter_drop_down.selectByValue("Cycling_value");
        List<WebElement> category_value = driver.findElements(By.className("category-banner"));

        for(WebElement cat_value :category_value ){
            String duration_value = cat_value.getText();
            if(cat_value.equals(Cycling_value)){
                System.out.println("functions are working as expected");
            }else{
                System.out.println("fucntion not wokring");
            }
        } 
    }

    
    public void clear_filter(){
        WebElement clear_filter = driver.findElement(By.xpath("(//div[@class='ms-3'])[1]"));
        clear_filter.click();
    }

    
    public void clear_category(){
        WebElement clear_category = driver.findElement(By.xpath("(//div[@class='ms-3'])[2]"));
        clear_category.click();
    }

    
    public void clear_adventure(){
        WebElement clear_adventure = driver.findElement(By.xpath("(//div[@class='ms-3'])[2]"));
        clear_adventure.click();
    }

    
    public void all_record_displayed(){
        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='activity-card']"));
        int card_size = cards.size();
        if(card_size==11){
            System.out.println("all function are working as expected");
        }else{
            System.out.println("not working");
        }
    }

}