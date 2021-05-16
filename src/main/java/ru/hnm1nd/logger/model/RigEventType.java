package ru.hnm1nd.logger.model;

public enum RigEventType {

    UNDEFINED("00"),
    OVERHEATING("01"),
    LACK_OF_STATUS("02"),
    DELTA("03"),
    ONLINE("04"),
    OFFLINE("05");

    private String code;

    RigEventType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
