/**
 * 
 */
package com.ak.testing.flipkart;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Khushboo Taneja
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber-json"},
        features = "classpath:flipkart",
        glue = {"com.ak.testing.flipkart"}
)

public class RunFunctionalTest {

}
