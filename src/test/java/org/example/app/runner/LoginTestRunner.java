package org.example.app.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        dryRun = false,
        monochrome = true,

        glue = {"org.example.app.stepDef","org.example.app.pageObject","org.example.app.hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoginTestRunner  extends AbstractTestNGCucumberTests
{


}
