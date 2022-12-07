package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        glue =  "steps",

        //when you set dry run to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        // when we set dry run to false, it starts execution again
        // we should enter "or" to make it execute both sprints
        // sprint: we can call it any name. no need to be sprint
        // for every scenario implementation we always  have to assign the dryrun to true to get the methods steps
        // and then assign it back to false for executing all the steps
        dryRun = false,
        tags = "@sprint3 or @sprint1",

        // to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        //pretty keyword prints the steps in the console to increase readability
        plugin = {"pretty"}



)


public class SmokeRunner {
}
