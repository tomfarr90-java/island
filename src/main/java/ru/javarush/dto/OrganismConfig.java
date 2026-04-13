package ru.javarush.dto;

import java.util.Map;

public class OrganismConfig {
    private Map<String,OrganismStats> organismSettings;
    private Map<String, Map<String,Integer>> eatingProbabilities;

    public OrganismConfig() {

    }

    public Map<String, OrganismStats> getOrganismSettings() {
        return organismSettings;
    }

    public void setOrganismSettings(Map<String, OrganismStats> organismSettings) {
        this.organismSettings = organismSettings;
    }

    public Map<String, Map<String, Integer>> getEatingProbabilities() {
        return eatingProbabilities;
    }

    public void setEatingProbabilities(Map<String, Map<String, Integer>> eatingProbabilities) {
        this.eatingProbabilities = eatingProbabilities;
    }
}
