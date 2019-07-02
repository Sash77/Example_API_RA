package model.entity;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Arrays;
import java.util.Map;

public class EntityRequest {
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("code")
    private int code;

    @SerializedName("simple")
    private boolean simple;

    @SerializedName("shouldbe")
    private String[] shouldbe;

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

    public boolean isSimple() {
        return simple;
    }

    public String[] getShouldbe() {
        Arrays.sort(shouldbe);
        return shouldbe;
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

    public String returnValueFromBody(String key){

        String stringToReturn = "";


        if (body.length != 0) {
            for (int i = 0; i < body.length; i++) {
                for (Map.Entry<String, String> item : body[i].entrySet()) {
                    if (item.getKey().equalsIgnoreCase(key)){
                        stringToReturn = item.getValue();
                        break;
                    }
                }
            }
        }

        return stringToReturn;
    }
}
