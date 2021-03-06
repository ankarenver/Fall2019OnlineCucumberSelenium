package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        tags = "",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"

        }
)
//mvn clean verify -q  run in quite mode
public class CucumberRunner {

}
