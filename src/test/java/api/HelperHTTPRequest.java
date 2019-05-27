package api;

import appmanager.ApplicationManager;
import com.google.gson.internal.LinkedTreeMap;
import model.entity.EntityRequest;
import model.enums.SchemaType;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelperHTTPRequest extends APIBase {

    public HelperHTTPRequest(ApplicationManager app) {
        super(app);
    }

    public int sendHeadersPost(EntityRequest entityRequest, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        String body;

        if (endPoint.contains("document")){
            body = String.format("{\"id\":\"%s\"}", app.getDocID());
        }else  if (endPoint.contains("overview")){
            body = String.format("{ \"documentType\": \"ED\", \"control\":\"%s\", \"size\": 0, \"page\": 0}", app.getDocID());
        }else {
            body = String.format("{\"id\":\"%s\"}", app.getDocID());
        }

        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address", endPoint);

        return sendRequestHttpPost(mapHandle, returnHeaderParams(entityRequest), body);

    }

    public int sendNullInBodyPost(EntityRequest entityRequest, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address", endPoint);

        return sendRequestHttpPost(mapHandle, returnHeaderParams(entityRequest), getBodyInHashMap(entityRequest.getBody()));

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

    public List<String> getSchemaTypeList(){
        return  Arrays.asList(SchemaType.values()).stream().//pass array in stream
                map(l->new String(l.name())).//for each array's item create string and put there name of enum
                collect(Collectors.toList());//create list of strings with names of enums data
    }

}
