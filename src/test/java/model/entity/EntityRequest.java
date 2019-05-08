package model.entity;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class EntityRequest {
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("code")
    private int code;

    @SerializedName("head")
    protected LinkedTreeMap<String, String>[] head = new LinkedTreeMap[0];

    @SerializedName("body")
    protected LinkedTreeMap<String, String>[] body = new LinkedTreeMap[0];

    @SerializedName("wellformed")
    protected String wellFormed;

    public String getTestCase() {
        return testCase;
    }

    public int getCode() {
        return code;
    }

    public LinkedTreeMap<String, String>[] getHead() {
        return head;
    }

    public LinkedTreeMap<String, String>[] getBody() {
        return body;
    }

    public String getWellFormed() {
        return wellFormed;
    }
}
