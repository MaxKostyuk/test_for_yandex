package cheks;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CommonChecks {

    @Step("Checking if received code equals to expected {expectedCode}")
    public static void checkResponseCode(int expectedCode, Response response) {
        Assertions.assertEquals(expectedCode, response.statusCode(),
                String.format("Received code %d does not equal to expected %d", response.statusCode(), expectedCode));
    }
}
