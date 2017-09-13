package steps;


import cucumber.api.java.After;
import helpers.DriversMethod;


public class Hooks {

    @After
    public void closeBrowser(){
        DriversMethod.closeWebDriver();
    }
}
