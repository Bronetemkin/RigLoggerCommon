package ru.hnm1nd.logger.model;

public class NotificationMessage {

    private String eventCode;
    private String eventData;
    private RigInfo rigInfo;
    private RigEventType rigEventType;
    private String msg;

    public NotificationMessage() {}

    public NotificationMessage(RigInfo rigInfo, RigEventType rigEventType, String msg) {
        this.rigInfo = rigInfo;
        this.rigEventType = rigEventType;
        this.eventCode = rigEventType.getCode();
        this.msg = msg;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventData(String eventData) {
        this.eventData = eventCode + ":" + eventData.replaceAll("\\s", "");
    }

    public String getEventData() {
        return eventData;
    }

    public RigInfo getRigInfo() {
        return rigInfo;
    }

    public void setRigInfo(RigInfo rigInfo) {
        this.rigInfo = rigInfo;
    }

    public RigEventType getRigEventType() {
        return rigEventType;
    }

    public void setRigEventType(RigEventType rigEventType) {
        this.rigEventType = rigEventType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
