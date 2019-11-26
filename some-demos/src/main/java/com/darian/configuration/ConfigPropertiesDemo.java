package com.darian.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.URL;


public class ConfigPropertiesDemo {

    public static void main(String[] args) throws ConfigurationException {

        URL resourceURL = Thread.currentThread().getContextClassLoader()
                .getResource("application.properties");
        Configuration configuration = new PropertiesConfiguration(resourceURL);
        System.out.println(configuration.getInt("age"));

    }
}
