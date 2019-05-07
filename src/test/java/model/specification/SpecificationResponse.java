package model.specification;

import appmanager.ApplicationManager;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class SpecificationResponse {
    protected ApplicationManager app;

    public SpecificationResponse(ApplicationManager app) {
        this.app = app;
    }

    private ResponseSpecification responseRegular = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public ResponseSpecification getResponseRegular() {
        return responseRegular;
    }
}
