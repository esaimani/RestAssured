package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reportUtils.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint : " + query.getBaseUri());
        ExtentReportManager.logInfoDetails("Content Type :" + query.getContentType());
        ExtentReportManager.logInfoDetails("Method : " + query.getMethod());
        ExtentReportManager.logInfoDetails("Request Body :" + query.getBody());

    }

    public static RequestSpecification getRequestSpecification(String endPoint, Object payload, Map<String, Object> headers) {

        return RestAssured.given().baseUri(endPoint).headers(headers).contentType(ContentType.JSON).body(payload);
    }

    public static Response performPost(String endPoint, Object payload, Map<String, Object> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, payload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        return response;
    }
}
