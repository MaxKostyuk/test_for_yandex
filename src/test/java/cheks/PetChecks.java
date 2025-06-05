package cheks;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.pet.Pet;

public class PetChecks {

    @Step("Checking received pet body is valid and equals to expected one")
    public static void checkPetBody(Pet expectedPet, Response response) {
        Allure.addAttachment("Expected body", expectedPet.toString());
        Allure.addAttachment("Actual body", response.body().asString());
        Pet actualPet = CommonChecks.assertionParseSuccessful(response.asString(), Pet.class);
        CommonChecks.assertionEquals(expectedPet, actualPet, "Received pet body does not equal to expected one");
    }
}
