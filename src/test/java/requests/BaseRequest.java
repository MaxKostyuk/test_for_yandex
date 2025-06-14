package requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import io.restassured.RestAssured;
import logging.RestAssuredLoggerFilter;

public class BaseRequest {
    private static final ObjectMapper mapper;

    static {
        RestAssured.baseURI = Config.get().getBaseUrl();
        RestAssured.filters(new RestAssuredLoggerFilter());
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    public static <T> T fromJson(String jsonString, Class<T> classOfT) throws Exception {
        return mapper.readValue(jsonString, classOfT);
    }

}
