package ru.hnm1nd.logger.model;

public class TemperatureInfo implements Cloneable {

    private double mainTemperature;
    private double[] temperatures;

    public TemperatureInfo() {}

    public TemperatureInfo(double mainTemperature) {
        this.mainTemperature = mainTemperature;
        this.temperatures = new double[0];
    }

    public TemperatureInfo(double mainTemperature, double[] temperatures) {
        this.mainTemperature = mainTemperature;
        this.temperatures = temperatures;
    }

    public void setTemperatures(double[] temperatures) {
        this.temperatures = temperatures;
    }

    public void setMainTemperature(double mainTemperature) {
        this.mainTemperature = mainTemperature;
    }

    public double getMainTemperature() {
        return mainTemperature;
    }

    public double[] getTemperatures() {
        return temperatures;
    }

    @Override
    public TemperatureInfo clone() {
        try {
            return (TemperatureInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
