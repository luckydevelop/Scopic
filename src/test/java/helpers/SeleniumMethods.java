package helpers;


import org.openqa.selenium.WebDriver;

public class SeleniumMethods {

   SeleniumMethods(WebDriver driver) {
       this.driver = driver;
   }

   private WebDriver driver;

   public WebDriver getDriver(){
       return driver;
   }

   public void openUrl(String path){
       driver.get(path);
   }
}
