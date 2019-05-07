package model.entity;

import com.google.gson.annotations.SerializedName;

public class EntityHeader {
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("contentKey")
    private String contentKey;

    @SerializedName("contentValue")
    private String contentValue;

    @SerializedName("acceptKey")
    private String acceptKey;

    @SerializedName("acceptValue")
    private String acceptValue;

    @SerializedName("code")
    private int code;

    public String getTestCase() {
        return testCase;
    }

    public String getContentKey() {
        return contentKey;
    }

    public String getContentValue() {
        return contentValue;
    }

    public String getAcceptKey() {
        return acceptKey;
    }

    public String getAcceptValue() {
        return acceptValue;
    }

    public int getCode() {
        return code;
    }
}
