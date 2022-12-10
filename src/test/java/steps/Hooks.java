package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    // use io.cucumber.java to import this hooks
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();  // this replaces the first step in feature files (Given user is navigated to HRMS application)
    }

    @After
    public void postCondition(){
        closeBrowser();
    }

}
