package model.specification;

import appmanager.ApplicationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.entity.EntityHeader;

import java.util.HashMap;
import java.util.Map;

public class SpecificationRequest {

    protected ApplicationManager app;

    private RequestSpecification requestRegular;
//    private RequestSpecification requestForHeader;

    public SpecificationRequest(ApplicationManager app) {
        this.app = app;

        requestRegular = new RequestSpecBuilder()
                .setBaseUri(app.getURL())
                .setPort(app.getApiPort())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

//    public RequestSpecification getRequestForHeader(EntityHeader header) {
//
//        Map<String, String> headerMap = new HashMap<>();
//
//        if (header.getContentKey()!=null|header.getContentValue()!=null){
//            headerMap.put(header.getContentKey(), header.getContentValue());
//        }
//
//        if (header.getAcceptKey()!=null|header.getAcceptValue()!=null){
//            headerMap.put(header.getAcceptKey(), header.getAcceptValue());
//        }
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
//                .setBaseUri(app.getURL())
//                .setPort(app.getApiPort())
//                .setBody(String.format("{\"id\":%s}",app.getDocID()))
//                .log(LogDetail.ALL);
//
//        if (headerMap.size()>0){
//            requestSpecBuilder.addHeaders(headerMap);
//        }
//
//        requestForHeader = requestSpecBuilder.build();
//
//        return requestForHeader;
//    }

    public RequestSpecification getRequestRegular() {
        return requestRegular;
    }
}
