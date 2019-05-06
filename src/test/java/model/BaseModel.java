package model;

import com.google.gson.internal.LinkedTreeMap;

public interface BaseModel {
    BaseModel withCode(int code) ;

    BaseModel withCodeText(String codeText);

    BaseModel withMessage(String message);

    BaseModel withMessageToLog(String messageToLog);

    LinkedTreeMap<String, String>[] getHeadMap();

    LinkedTreeMap<String, String>[] getBodyMap();

    void setTestCase(String testCase);

    String getTestCase();

    String getAccept();

    String getContent();

    String getMessageToLog();

    BaseModel processAccept();

    BaseModel processContent();

    void processResponce();

    String processBody();

}


