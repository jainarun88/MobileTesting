package cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(features = "src/main/java/bdd/feature/Shopping.feature",
				glue = {"/src/test/java/stepDef/ShoppingStepsDef.java"},
				tags = {"~@Ignore"},
				format = {
						"pretty",
						"html:target/cucumber-reports/cucumber-pretty",
						"json:target/cucumber-reports/CucumberTestReport.json",
						"rerun:target/cucumber-reports/rerun.txt"
					})
public class ShoppingIntegrationTest extends AbstractTestNGCucumberTests {

}
