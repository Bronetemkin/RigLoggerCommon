package ru.hnm1nd.logger.model;

public class RigInfo implements Comparable<RigInfo> {

    private String msgId;
    private String status = "";
    private String subStatus = "";
    private String statusDescription = "";
    private String name = "";
    private GPUInfo[] gpus = new GPUInfo[0];
    private long timestamp;
    private double speed;
    private String speedUnit;

    public RigInfo() {}

    public String getName() {
        return name;
    }

    public RigInfo setName(String name) {
        this.name = name;
        return this;
    }

    public GPUInfo[] getGpus() {
        return gpus;
    }

    public RigInfo setGpus(GPUInfo[] gpus) {
        this.gpus = gpus;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public RigInfo setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public RigInfo setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public RigInfo setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
        return this;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
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

    @Override
    public int compareTo(RigInfo arg1) {
        long arg0tm = getTimestamp(), arg1tm = arg1.getTimestamp();
        if (RigStatus.LACK_OF_STATUS.name().equals(getStatus())) {
            arg0tm = 0;
        }
        if (RigStatus.LACK_OF_STATUS.name().equals(arg1.getStatus())) {
            arg1tm = 0;
        }
        return (int) (arg0tm - arg1tm);
    }
}
