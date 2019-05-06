package api;

import appmanager.APIBase;
import appmanager.ApplicationManager;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class WorkListAPI extends APIBase {

    private BaseModel result;

    public WorkListAPI(ApplicationManager app){
        super(app);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BaseModel getResult() {
        return result;
    }

    public String getBody(LinkedTreeMap<String, String>[] additionalBody, String value, String credentialTegName) {

        int qntItems = additionalBody.length;

        HashMap<String, String> bodyMap = new HashMap<>();

        if (qntItems!=0) {
            for (int i = 0; i < qntItems; i++) {
                for (Map.Entry<String, String> item : additionalBody[i].entrySet()) {
                    bodyMap.put(item.getKey(), item.getValue());
                }
            }
        }
        return getBodyForRequest(bodyMap);
    }

    public void logTrace(String value) {
        app.getLogger().trace(value);
    }

    public void clearVariables() {
        result = null;
    }
}
