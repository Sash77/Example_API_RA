package appmanager;

import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public abstract class APIBase {

    protected ApplicationManager app;

    public APIBase() {

    }

    public APIBase(ApplicationManager app) {
        this.app = app;
    }

    public HashMap<String, String> returnHeaderParams(BaseModel modelObj) {

        int qntItems = modelObj.getHeadMap().length;
        HashMap<String, String> params = new HashMap<>();

        if (qntItems == 0) {
            params.put("content-type", "application/json");
            params.put("accept", "application/json");
        } else {

            LinkedTreeMap<String, String>[] headMap = modelObj.getHeadMap();

            if (qntItems != 0) {
                for (int i = 0; i < qntItems; i++) {
                    for (Map.Entry<String, String> item : headMap[i].entrySet()) {
                        params.put(item.getKey(), item.getValue());
                    }
                }
            }

        }

//        if (!modelObj.isWithoutTicket()) {
//            params.put("pdapp-auth-ticket", app.getApiToken());
//        }

        return params;
    }

    protected String getBodyForRequest(HashMap<String, String> params) {
        StringBuilder body = new StringBuilder();
        int qntItems = params.size();

        if (qntItems != 0) {

                body.append("{");
                for (Map.Entry<String, String> item : params.entrySet()) {
                    --qntItems;
                    body.append(String.format("\"%s\": \"%s\"", item.getKey(), item.getValue()) + ((qntItems == 0) ? "" : ","));
                }
                body.append("}");

        }else {
                body.append("{}");
        }

        return body.toString();
    }

    protected void logTrace(String value) {
        app.getLogger().trace(value);
    }

}
