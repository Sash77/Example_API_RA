package appmanager;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import model.BaseModel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class APIBase {

    protected ApplicationManager app;

    public APIBase() {

    }

    public APIBase(ApplicationManager app) {
        this.app = app;
    }

    protected Request requestHttpPost(String url, HashMap<String, String> params, String body, ContentType contentType) {

        Request requestHTTP = Request.Post(url);

        for (Map.Entry<String, String> item : params.entrySet()) {
            requestHTTP.addHeader(item.getKey().trim(), item.getValue().trim());
        }

        requestHTTP.setCacheControl("no-cache");
        requestHTTP.bodyString(String.format(body), contentType);

        return requestHTTP;
    }

    protected Request requestHttpPostFile(String url, HashMap<String, String> params, ContentType contentType, String fileAddress) {

        Request requestHTTP = Request.Post(url);

        for (Map.Entry<String, String> item : params.entrySet()) {
            requestHTTP.addHeader(item.getKey().trim(), item.getValue().trim());
        }

        requestHTTP.setCacheControl("no-cache");
        requestHTTP.bodyFile(new File(fileAddress), contentType);

        return requestHTTP;
    }

    protected Request requestHttpGet(String url, HashMap<String, String> params) {

        Request requestHTTP = Request.Get(url);

        for (Map.Entry<String, String> item : params.entrySet()) {
            requestHTTP.addHeader(item.getKey().trim(), item.getValue().trim());
        }

        requestHTTP.setCacheControl("no-cache");

        return requestHTTP;
    }

    protected BaseModel sendRequestHttpPost(HashMap<String, String> mapHandle, HashMap<String, String> mapParams, String body) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        //[0] status code
        //[1] codeText
        //[2] body
        //[3] content type
        //[4] short message
        final String resultHandle[] = new String[5];
        boolean isAcceptJson = false;
        String fileAddress = mapHandle.get("file");
        Request requestHTTP;

        BaseModel result;

        for (Map.Entry<String, String> itemMapParams : mapParams.entrySet()) {
            if (itemMapParams.getKey().toLowerCase().contains("accept")) {
                isAcceptJson = itemMapParams.getValue().contains("json");
                break;
            }
        }

        logTrace("Create http request Post...");
        if (fileAddress!=null) {
            requestHTTP = requestHttpPostFile(String.format(app.getURL() + "%s", mapHandle.get("address")),
                    mapParams,
                    ContentType.APPLICATION_OCTET_STREAM,
                    fileAddress);
        }else {
            requestHTTP = requestHttpPost(String.format(app.getURL() + "%s", mapHandle.get("address")),
                    mapParams,
                    body,
                    null);
        }

        logTrace("Send request Post...");
        Response responseHTTP = getExecutor().execute(requestHTTP);

        logTrace("Handle response...");
        responseHTTP.handleResponse(new BasicResponseHandler() {

                                        @Override
                                        public String handleResponse(final HttpResponse response) throws IOException {
                                            StatusLine statusLine = response.getStatusLine();
                                            HttpEntity entity = response.getEntity();

                                            resultHandle[0] = String.valueOf(statusLine.getStatusCode());
                                            resultHandle[1] = statusLine.getReasonPhrase();
                                            resultHandle[2] = EntityUtils.toString(entity);
                                            if (entity.getContentType().getElements().length!=0){
                                                resultHandle[3] = entity.getContentType().getElements()[0].getName();
                                            }
                                            resultHandle[4] = String.valueOf((resultHandle[2].length() <= 100) ? resultHandle[2].length() - 1 : 100);

//                                            logTrace("Get request code: " + resultHandle[0] + " ;codeText: " + resultHandle[1] + " ;body: " + resultHandle[2].substring(0,Integer.parseInt(resultHandle[3])));
                                            logTrace("Get request code: " + resultHandle[0] + " ;codeText: " + resultHandle[1] + " ;body: " + resultHandle[2]);
                                            return "";
                                        }
                                    }
        );

        String messageToLogShort = resultHandle[2].substring(0, Integer.parseInt(resultHandle[4]));

//        if (isAcceptJson) {

            result = getResultFromJSON(resultHandle, messageToLogShort, mapHandle);

//        } else {
//
//            result = getResultFromXML(resultHandle, messageToLogShort, mapHandle);
//
//        }

        return result;
    }

    protected BaseModel sendRequestHttpGet(HashMap<String, String> mapHandle, HashMap<String, String> mapParams, boolean dontExpectBody) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        //[0] status code
        //[1] codeText
        //[2] body
        //[3] content type
        //[4] short message
        final String resultHandle[] = new String[5];
        final boolean dontExpectBodyHandle = dontExpectBody;
        boolean isAcceptJson = false;

        BaseModel result;

        for (Map.Entry<String, String> itemMapParams : mapParams.entrySet()) {
            if (itemMapParams.getKey().toLowerCase().contains("accept")) {
                isAcceptJson = itemMapParams.getValue().contains("json");
                break;
            }
        }

        logTrace("Create http request Get...");
        Request requestHTTP = requestHttpGet(String.format(app.getURL() + "%s", mapHandle.get("address")), mapParams);

        logTrace("Send request Get...");
        Response responseHTTP = getExecutor().execute(requestHTTP);

        logTrace("Handle response...");
        responseHTTP.handleResponse(new BasicResponseHandler() {

                                        @Override
                                        public String handleResponse(final HttpResponse response) throws IOException {
                                            StatusLine statusLine = response.getStatusLine();
                                            HttpEntity entity = response.getEntity();

                                            resultHandle[0] = String.valueOf(statusLine.getStatusCode());
                                            resultHandle[1] = statusLine.getReasonPhrase();
                                            resultHandle[2] = EntityUtils.toString(entity);
                                            if (entity.getContentType().getElements().length!=0){
                                                resultHandle[3] = entity.getContentType().getElements()[0].getName();
                                            }
                                            resultHandle[4] = String.valueOf((resultHandle[2].length() <= 100) ? resultHandle[2].length() - 1 : 100);

//                                            logTrace("Get request code: " + resultHandle[0] + " ;codeText: " + resultHandle[1] + " ;body: " + resultHandle[2].substring(0,Integer.parseInt(resultHandle[3])));
                                            logTrace("Get request code: " + resultHandle[0] + " ;codeText: " + resultHandle[1] + " ;body: " + resultHandle[2]);
                                            return "";
                                        }
                                    }
        );

        String messageToLogShort = resultHandle[2].substring(0, Integer.parseInt(resultHandle[4]));

//        if (isAcceptJson) {

            result = getResultFromJSON(resultHandle, messageToLogShort, mapHandle);

//        } else {
//
//            result = getResultFromXML(resultHandle, messageToLogShort, mapHandle);
//
//        }
        return result;
    }

    private BaseModel getResultFromJSON(String[] resultHandle, String messageToLogShort, HashMap<String, String> mapHandle) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        BaseModel result;

        Class regularClass = Class.forName(mapHandle.get("regular"));
        Class exceptionClass = Class.forName(mapHandle.get("exception"));

            Gson gson = new Gson();
            if (resultHandle[0].equals("200")) {

                try {
                    result = gson.fromJson(resultHandle[2], (Type) regularClass);
                    result.withCode(Integer.parseInt(resultHandle[0]))
                            .withCodeText(resultHandle[1])
                            .withMessageToLog(resultHandle[2]);
                } catch (Exception e) {
                    result = (BaseModel) exceptionClass.newInstance();
                    result.withCode(Integer.parseInt(resultHandle[0]))
                            .withCodeText(resultHandle[1])
                            .withMessage(messageToLogShort)
                            .withMessageToLog(resultHandle[2]);
                    logTrace("Error(json/" + resultHandle[0] + ": " + messageToLogShort);
                }

            } else {

                try {
                    result = gson.fromJson(resultHandle[2], (Type) exceptionClass);
                    result.withCode(Integer.parseInt(resultHandle[0]))
                            .withCodeText(resultHandle[1])
                            .withMessageToLog(resultHandle[2]);
                } catch (Exception e) {
                    result = (BaseModel) exceptionClass.newInstance();
                    result.withCode(Integer.parseInt(resultHandle[0]))
                            .withCodeText(resultHandle[1])
                            .withMessage(messageToLogShort)
                            .withMessageToLog(resultHandle[2]);
                    logTrace("Error(json/" + resultHandle[0] + ": " + messageToLogShort);
                }
            }

        return result;
    }

//    private BaseModel getResultFromXML(String[] resultHandle, String messageToLogShort, HashMap<String, String> mapHandle) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//
//        BaseModel result;
//
//        Class regularClass = Class.forName(mapHandle.get("regular"));
//        Class exceptionClass = Class.forName(mapHandle.get("exception"));
//
//            XStream xstream = new XStream();
//
//            if (resultHandle[0].equals("200")) {
//                xstream.processAnnotations(regularClass);
//                String stringXML = resultHandle[2].replace(mapHandle.get("regularTag"),
//                        regularClass.getName().substring(regularClass.getName().lastIndexOf(".") + 1));
//                try {
//                    result = (BaseModel) regularClass.cast(xstream.fromXML(stringXML));
//                    result.withCode(Integer.parseInt(resultHandle[0]))
//                            .withCodeText(resultHandle[1])
//                            .withMessageToLog(resultHandle[2]);
//                } catch (Exception e) {
//                    result = (BaseModel) exceptionClass.newInstance();
//                    result.withCode(Integer.parseInt(resultHandle[0]))
//                            .withCodeText(resultHandle[1])
//                            .withMessage(messageToLogShort)
//                            .withMessageToLog(resultHandle[2]);
//                    logTrace("Error(xml/" + resultHandle[0] + ": " + messageToLogShort);
//                }
//            } else {
//                xstream.processAnnotations(exceptionClass);
//                String stringXML = resultHandle[2].replace(mapHandle.get("exceptionTag"),
//                        exceptionClass.getName().substring(exceptionClass.getName().lastIndexOf(".") + 1));
//                try {
//                    result = (BaseModel) exceptionClass.cast(xstream.fromXML(stringXML));
//                    result.withCode(Integer.parseInt(resultHandle[0]))
//                            .withCodeText(resultHandle[1])
//                            .withMessageToLog(resultHandle[2]);
//                } catch (Exception e) {
//                    result = (BaseModel) exceptionClass.newInstance();
//                    result.withCode(Integer.parseInt(resultHandle[0]))
//                            .withCodeText(resultHandle[1])
//                            .withMessage(messageToLogShort)
//                            .withMessageToLog(resultHandle[2]);
//                    logTrace("Error(xml/" + resultHandle[0] + ": " + messageToLogShort);
//                }
//            }
//
//        return result;
//    }

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

    private Executor getExecutor() {
        return Executor.newInstance();
    }

    protected void logTrace(String value) {
        app.getLogger().trace(value);
    }

}
