package ru.hnm1nd.logger.model;

public class GPUInfo implements Cloneable {

    private String gpuName;
    private String gpuId;
    private FanInfo fanInfo;
    private TemperatureInfo temperatureInfo;
    private double speed;
    private String speedUnit;

    public GPUInfo() {}

    public GPUInfo (String gpuName, FanInfo fanInfo, TemperatureInfo temperatureInfo, String gpuId) {
        this.gpuName = gpuName;
        this.fanInfo = fanInfo;
        this.temperatureInfo = temperatureInfo;
        this.gpuId = gpuId;
    }

    public String getGpuId() {
        return gpuId;
    }

    public String getGpuName() {
        return gpuName;
    }

    public FanInfo getFanInfo() {
        return fanInfo;
    }

    public TemperatureInfo getTemperatureInfo() {
        return temperatureInfo;
    }

    public double getSpeed() {
        return speed;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public void setSpeed(double speed, String speedUnit) {
        this.speed = speed;
        this.speedUnit = speedUnit;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public void setGpuId(String gpuId) {
        this.gpuId = gpuId;
    }

    public void setFanInfo(FanInfo fanInfo) {
        this.fanInfo = fanInfo;
    }

    public void setTemperatureInfo(TemperatureInfo temperatureInfo) {
        this.temperatureInfo = temperatureInfo;
    }

    @Override
    public GPUInfo clone() {
        try {
            return (GPUInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
