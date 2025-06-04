package requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import io.restassured.RestAssured;

public class BaseRequest {
    private static final ObjectMapper mapper;

    static {
        RestAssured.baseURI = Config.get().getBaseUrl();
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

}
