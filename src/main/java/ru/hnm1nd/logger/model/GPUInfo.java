package ru.hnm1nd.logger.model;

public class GPUInfo {

    private String gpuName;
    private String gpuId;
    private FanInfo fanInfo;
    private TemperatureInfo temperatureInfo;
    private Double speed;
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

    public Double getSpeed() {
        return speed;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public void setSpeed(Double speed, String speedUnit) {
        this.speed = speed;
        this.speedUnit = speedUnit;
    }

}
