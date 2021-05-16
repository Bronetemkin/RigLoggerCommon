package ru.hnm1nd.logger.model;

public class TemperatureInfo {

    private Double mainTemperature;
    private Double[] temperatures;

    public TemperatureInfo() {}

    public TemperatureInfo(double mainTemperature) {
        this.mainTemperature = mainTemperature;
        this.temperatures = new Double[0];
    }

    public TemperatureInfo(Double mainTemperature, Double[] temperatures) {
        this.mainTemperature = mainTemperature;
        this.temperatures = temperatures;
    }

    public void setTemperatures(Double[] temperatures) {
        this.temperatures = temperatures;
    }

    public void setMainTemperature(Double mainTemperature) {
        this.mainTemperature = mainTemperature;
    }

    public Double getMainTemperature() {
        return mainTemperature;
    }

    public Double[] getTemperatures() {
        return temperatures;
    }

}
