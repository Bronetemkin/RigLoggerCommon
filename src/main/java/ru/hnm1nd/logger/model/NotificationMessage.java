package ru.hnm1nd.logger.model;

public class NotificationMessage {

    private RigInfo rigInfo;
    private String rigEventType;
    private String msg;

    public RigInfo getRigInfo() {
        return rigInfo;
    }

    public void setRigInfo(RigInfo rigInfo) {
        this.rigInfo = rigInfo;
    }

    public String getRigEventType() {
        return rigEventType;
    }

    public void setRigEventType(String rigEventType) {
        this.rigEventType = rigEventType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
