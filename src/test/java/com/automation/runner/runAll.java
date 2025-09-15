package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/login/Login.feature"},  // आपके feature file का path
        glue = {"com.automation.login"},                           // Step Definitions का package
        plugin = {
                "pretty",                                             // Console output को readable बनाता है
                "json:target/cucumber-report.json",                   // JSON report generate करेगा
                "html:target/cucumber-html-report"                    // HTML report generate करेगा
        },
        monochrome = true                                         // Console output clean readable format में होगा
)
public class runAll {
}
