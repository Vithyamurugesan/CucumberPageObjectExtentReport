package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features= {"@target/failedrerun.txt"},
			 glue="com.definitions",
			 plugin= {
					 "usage",
					 "html:./reports/cumcumber-reports/cucumber-html/index.html",
					 "rerun:target/failedrerun.txt"},
			 monochrome=true)
public class RerunfailedRunner extends AbstractTestNGCucumberTests {
	

}
