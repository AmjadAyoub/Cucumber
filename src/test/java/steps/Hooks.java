package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;
import utils.CommonMethods;

import java.util.Scanner;

public class Hooks extends CommonMethods {
    // use io.cucumber.java to import this hooks
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();  // this replaces the first step in feature files (Given user is navigated to HRMS application)
    }
     //here we use the special class called scenario class from cucumber
    // this class holds the complete information of your execution
    @After
    public void postCondition(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            //failed screenshot will be available inside failed folder
          pic =  takeScreenShot("failed/" + scenario.getName());
        }else {
            pic = takeScreenShot("passed/" + scenario.getName());
        }

        // to attach the screenshot in our report
        scenario.attach(pic,"image/png", scenario.getName());

        closeBrowser();
    }

}
