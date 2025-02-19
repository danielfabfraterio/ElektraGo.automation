package com.elektrago.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/resources/com/elektrago/feature") // Carpeta donde están los archivos .feature
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "src/test/java/com/elektrago/stepDefinitions") // Paquete donde están los step definitions
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/index.html")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Escenario1") // Agregar Tag de Escenario 
public class RunFeature {
}