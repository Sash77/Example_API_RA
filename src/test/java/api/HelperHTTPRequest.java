package api;

import appmanager.ApplicationManager;
import com.google.gson.internal.LinkedTreeMap;
import model.entity.EntityRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelperHTTPRequest extends APIBase {

    public HelperHTTPRequest(ApplicationManager app) {
        super(app);
    }

    public int sendHeadersPost(EntityRequest entityRequest, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        String body = String.format("{\"id\":\"%s\"}", app.getDocID());

        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address", endPoint);

        return sendRequestHttpPost(mapHandle, returnHeaderParams(entityRequest), body);

    }

//    public int worklistTreeGetOperation(HashMap<String, String> params, String body, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
//        HashMap<String, String> mapHandle = new HashMap<>();
//        mapHandle.put("address",endPoint);
//
//
//        return sendRequestHttpGet(mapHandle, params, false);
//
//    }

    public String getBodyInHashMap(LinkedTreeMap<String, String>[] additionalBody) {

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
}
