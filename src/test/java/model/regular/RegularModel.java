package model.regular;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;

import java.util.Map;

abstract public class RegularModel implements BaseModel {

    @SerializedName("testCase")
    protected String testCase;

    @SerializedName("accept")
    protected String accept;

    @SerializedName("content")
    protected String content;

    @SerializedName("code")
    protected int code;

    @SerializedName("codeText")
    protected String codeText;

    @SerializedName("additionalUrl")
    protected String additionalUrl;

    @SerializedName("head")
    protected LinkedTreeMap<String, String>[] head = new LinkedTreeMap[0];

    @SerializedName("body")
    protected LinkedTreeMap<String, String>[] body = new LinkedTreeMap[0];

    protected String message;

    protected String messageToLog = "";

    public RegularModel withCode(int code) {
        this.code = code;
        return this;
    }

    public RegularModel withCodeText(String codeText) {
        this.codeText = codeText;
        return this;
    }

    public RegularModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public RegularModel withMessageToLog(String messageToLog) {
        this.messageToLog = messageToLog;
        return this;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public void addRowToHeadMap(String key, String value) {
        int qntItems = head.length;

        LinkedTreeMap<String, String>[] newHead = new LinkedTreeMap[head.length + 1];

        if (qntItems != 0) {
            for (int i = 0; i < qntItems; i++) {
                for (Map.Entry<String, String> item : head[i].entrySet()) {
                    newHead[i] = new LinkedTreeMap<String, String>();
                    newHead[i].put(item.getKey(), item.getValue());
                }
            }
        }

        newHead[head.length] = new LinkedTreeMap<String, String>();
        newHead[head.length].put(key, value);

        head = newHead;
    }

    public void addRowToBodyMap(String key, String value) {
        int qntItems = body.length;

        LinkedTreeMap<String, String>[] newBody = new LinkedTreeMap[body.length + 1];

        if (qntItems != 0) {
            for (int i = 0; i < qntItems; i++) {
                for (Map.Entry<String, String> item : body[i].entrySet()) {
                    newBody[i] = new LinkedTreeMap<String, String>();
                    newBody[i].put(item.getKey(), item.getValue());
                }
            }
        }

        newBody[body.length] = new LinkedTreeMap<String, String>();
        newBody[body.length].put(key, value);

        body = newBody;
    }

    public int getCode() {
        return code;
    }

    public String getCodeText() {
        return codeText;
    }

    public String getTestCase() {
        return testCase;
    }

    public String getMessageToLog() {
        return messageToLog;
    }

    public LinkedTreeMap<String, String>[] getBodyMap() {
        return body;
    }

    public LinkedTreeMap<String, String>[] getHeadMap() {
        return head;
    }

    public String getAccept() {

        return accept;
    }

    public String getContent() {
        return content;
    }

    public String getAdditionalUrl() {
        return additionalUrl;
    }

    public RegularModel processAccept() {

        if (head.length != 0) {
            for (int i = 0; i < head.length; i++) {
                for (Map.Entry<String, String> itemMapParams : head[i].entrySet()) {
                    if (itemMapParams.getKey().toLowerCase().contains("accept")) {
                        accept = (itemMapParams.getValue().toLowerCase().contains("json"))?"json":"xml";
                        break;
                    }

                }
            }
        }
        return this;
    }

    public RegularModel processContent() {

        if (head.length != 0) {
            for (int i = 0; i < head.length; i++) {
                for (Map.Entry<String, String> itemMapParams : head[i].entrySet()) {
                    if (itemMapParams.getKey().toLowerCase().contains("content-type")) {
                        content = (itemMapParams.getValue().toLowerCase().contains("json"))?"json":"xml";
                        break;
                    }

                }
            }
        }
        return this;
    }

    public void processResponce(){

    }

    public String processBody() {

        return "";
    }


}
