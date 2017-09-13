package steps;

import cucumber.api.java.en.Given;
import helpers.DriversMethod;
import helpers.SeleniumMethods;
import pages.HomePage;


public class Step {

    SeleniumMethods seleniumMethods = DriversMethod.NewOrExistingSeleniumMethods();


        @Given("^HomePage is opened$")
        public void homepage_is_opened()  {
            System.out.println("Wow!");
            HomePage homePage = new HomePage();



            seleniumMethods.openUrl("http://www.toolsqa.com");
        }



}
