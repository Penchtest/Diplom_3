package site.nomoreparties.stellarburgers.api_methods;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestRequest {
    public RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://stellarburgers.nomoreparties.site/api/")
                .setContentType(ContentType.JSON)
                .build();
    }
}
