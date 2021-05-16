package ru.hnm1nd.logger.model;

public class FanInfo {

    private int[] fanSpeed;
    private double[] fanRPM;

    public FanInfo() {}

    public FanInfo(double[] fanRPM, int[] fanSpeed) {
        setFanRPM(fanRPM);
        setFanSpeed(fanSpeed);
    }

    public int[] getFanSpeed() {
        return fanSpeed;
    }

    private void setFanSpeed(int[] fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public double[] getFanRPM() {
        return fanRPM;
    }

    private void setFanRPM(double[] fanRPM) {
        this.fanRPM = fanRPM;
    }
}
