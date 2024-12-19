package com.elektrago.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/resources/com/elektrago/feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "src/java/com/elektrago/stepDefinitions")
public class RunFeature {
}