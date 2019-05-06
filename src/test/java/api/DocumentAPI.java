package api;

import appmanager.APIBase;
import appmanager.ApplicationManager;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;
import model.exception.*;
import model.regular.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentAPI extends APIBase {

    private BaseModel result;

    public DocumentAPI(ApplicationManager app){
        super(app);
    }

    public BaseModel documentDetailSimpleOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentDetailSimple);
        mapHandle.put("regular", RegularSimpleSchemaModel.class.getName());
        mapHandle.put("exception", ExceptionSimpleSchemaModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentDetailOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentDetail);
        mapHandle.put("regular", RegularRawSchemaModel.class.getName());
        mapHandle.put("exception", ExceptionRawSchemaModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentHeaderSimpleOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentHeaderSimple);
        mapHandle.put("regular", RegularSimpleEntityModel.class.getName());
        mapHandle.put("exception", ExceptionSimpleEntityModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentTabOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentTab);
        mapHandle.put("regular", RegularRawRecordModel.class.getName());
        mapHandle.put("exception", ExceptionRawRecordModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentTabSimpleOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentTabSimple);
        mapHandle.put("regular", RegularSimpleRecordModel.class.getName());
        mapHandle.put("exception", ExceptionSimpleRecordModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentTableOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentTable);
        mapHandle.put("regular", RegularRawEntityModel.class.getName());
        mapHandle.put("exception", ExceptionRawEntityModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentTableSimpleOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentTableSimple);
        mapHandle.put("regular", RegularSimpleEntityModel.class.getName());
        mapHandle.put("exception", ExceptionSimpleEntityModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentLineOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentLine);
        mapHandle.put("regular", RegularRawRecordModel.class.getName());
        mapHandle.put("exception", ExceptionRawRecordModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentLineSimpleOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentLineSimple);
        mapHandle.put("regular", RegularSimpleRecordModel.class.getName());
        mapHandle.put("exception", ExceptionSimpleRecordModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel documentHeaderOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.documentHeader);
        mapHandle.put("regular", RegularRawEntityModel.class.getName());
        mapHandle.put("exception", ExceptionRawEntityModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel overviewListOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.overViewList);
        mapHandle.put("regular", RegularRawSchemaModel.class.getName());
        mapHandle.put("exception", ExceptionRawSchemaModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel overviewListFullOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.overViewListFull);
        mapHandle.put("regular", RegularRawSchemaModel.class.getName());
        mapHandle.put("exception", ExceptionRawSchemaModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel worklistSelectionOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.workListSelection);
        mapHandle.put("regular", RegularWorklistSelectionModel.class.getName());
        mapHandle.put("exception", ExceptionWorklistSelectionModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel worklistTreePostOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.workListTree);
        mapHandle.put("regular", RegularNodeModel.class.getName());
        mapHandle.put("exception", ExceptionNodeModel.class.getName());

        result = sendRequestHttpPost(mapHandle, params, body);

        return result;
    }

    public BaseModel worklistTreeGetOperation(HashMap<String, String> params, String body) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address",EndPoints.workListTree);
        mapHandle.put("regular", RegularNodeModel.class.getName());
        mapHandle.put("exception", ExceptionNodeModel.class.getName());

        result = sendRequestHttpGet(mapHandle, params, false);

        return result;
    }

    public BaseModel getResult() {
        return result;
    }

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

    public void logTrace(String value) {
        app.getLogger().trace(value);
    }

    public void clearVariables() {
        result = null;
    }

}
