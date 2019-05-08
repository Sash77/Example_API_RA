package model.entity;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class EntityHeader {
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("code")
    private int code;

    @SerializedName("head")
    protected LinkedTreeMap<String, String>[] head = new LinkedTreeMap[0];

    public String getTestCase() {
        return testCase;
    }

    public int getCode() {
        return code;
    }

    public LinkedTreeMap<String, String>[] getHead() {
        return head;
    }
}
