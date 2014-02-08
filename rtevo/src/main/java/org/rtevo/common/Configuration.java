/**
 * 
 */
package org.rtevo.common;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Jan Corazza & Luka Bubalo
 * 
 */
public class Configuration {
    public int generations;
    public int robotsPerGeneration;
    public int robotMilliseconds;
    public int parallelSimulations;
    public int windowWidth;
    public int windowHeight;
    public float gravity;
    public float timeStep;
    public boolean GUI;
    public String save;
    public String load;
    public int presentationChromosomes;
    public int pause;
    public float mutationChance;
    public double satisfactory;

    public Configuration() {
        applyProperties(getDefaultProperties());
    }

    public Configuration(Properties p) {
        applyProperties(p);
    }

    private void applyProperties(Properties p) {
        robotsPerGeneration = Integer.parseInt(p.getProperty(
                "robotsPerGeneration", "100"));
        robotMilliseconds = Integer.parseInt(p
                .getProperty("robotSeconds", "20")) * 1000;
        parallelSimulations = Integer.parseInt(p.getProperty(
                "parallelSimulations", "7"));
        generations = Integer.parseInt(p.getProperty("generations", "-200"));
        satisfactory = Double
                .parseDouble(p.getProperty("satisfactory", "-200"));
        windowWidth = Integer.parseInt(p.getProperty("windowWidth", "1024"));
        windowHeight = Integer.parseInt(p.getProperty("windowHeight", "512"));
        gravity = Float.parseFloat(p.getProperty("gravity", "10"));
        timeStep = Float.parseFloat(p.getProperty("timeStep", "0.01"));
        GUI = Boolean.parseBoolean(p.getProperty("GUI", "true"));
        save = p.getProperty("save", "false");
        load = p.getProperty("load", "false");
        presentationChromosomes = Integer.parseInt(p.getProperty(
                "presentationChromosomes", "1"));
        pause = Integer.parseInt(p.getProperty("pause", "0"));
        mutationChance = Float.parseFloat(p.getProperty("mutationChance",
                "0.01"));

        if (generations == -200 && satisfactory == -200) {
            generations = 100;
        }
    }

    private static Properties getDefaultProperties() {
        Properties defaultProperties = new Properties();
        try {
            defaultProperties.load(Configuration.class
                    .getResourceAsStream("/default-configuration.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read default configuration");
        }
        return defaultProperties;
    }

}
