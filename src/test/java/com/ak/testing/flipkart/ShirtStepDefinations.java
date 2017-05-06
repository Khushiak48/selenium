/**
 * 
 */
package com.ak.testing.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Khushboo Taneja
 *
 */
public class ShirtStepDefinations {
	


	@Given("^Create firefox driver session$")
    public void create_firefox_driver_session() throws Throwable {
		WebDriver driver = new FirefoxDriver();
       }
    @Then("^Verify the Size of T-Shirt should be \"([^\"]*)\"$")
    public void verify_the_size_of_tshirt_should_be_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^Open the website \"([^\"]*)\" in firefox browser$")
    public void open_the_website_something_in_firefox_browser(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^Maximize the Window$")
    public void maximize_the_window() throws Throwable {
        throw new PendingException();
    }

    @And("^Keep the hover on \"([^\"]*)\" Tab$")
    public void keep_the_hover_on_something_tab(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^Click on \"([^\"]*)\" Link$")
    public void click_on_something_link(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^We wait for 3000 millisecond$")
    public void we_wait_for_3000_millisecond() throws Throwable {
        throw new PendingException();
    }

    @And("^Select the \"([^\"]*)\" Size from Size Section$")
    public void select_the_something_size_from_size_section(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^Click on \"([^\"]*)\" from filtered Men T-Shirts Section$")
    public void click_on_something_from_filtered_men_tshirts_section(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @And("^We wait for 6000 millisecond$")
    public void we_wait_for_6000_millisecond() throws Throwable {
        throw new PendingException();
    }

    @And("^Close the driver Session$")
    public void close_the_driver_session() throws Throwable {
        throw new PendingException();
    }

}
