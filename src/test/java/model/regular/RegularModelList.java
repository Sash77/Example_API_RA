package model.regular;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;

import java.util.ArrayList;
import java.util.Map;

abstract public class RegularModelList<T> extends ArrayList<T> implements BaseModel {

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

    protected String message;

    protected String messageToLog = "";

    @SerializedName("head")
    protected LinkedTreeMap<String, String>[] head = new LinkedTreeMap[0];

    @SerializedName("body")
    protected LinkedTreeMap<String, String>[] body = new LinkedTreeMap[0];

    public RegularModelList<T> withCode(int code) {
        this.code = code;
        return this;
    }

    public RegularModelList<T> withCodeText(String codeText) {
        this.codeText = codeText;
        return this;
    }

    public RegularModelList<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public RegularModelList<T> withMessageToLog(String messageToLog) {
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

    public String getMessageToLog() {
        return messageToLog;
    }

    public RegularModelList<T> processAccept() {

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

    public RegularModelList<T> processContent() {

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
