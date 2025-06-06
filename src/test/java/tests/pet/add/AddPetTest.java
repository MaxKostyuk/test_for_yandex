package tests.pet.add;

import cheks.CommonChecks;
import cheks.PetChecks;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.pet.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.PetRequest;
import tests.BaseTestClass;

import static data.provider.pet.PetProvider.singleValidPetProvider;

@Slf4j
@DisplayName("Add pet api tests")
public class AddPetTest extends BaseTestClass {

    private static Pet pet;

    @BeforeAll
    public static void setUp() {
        pet = singleValidPetProvider();
    }

    @Test
    @DisplayName("Positive test to add pet")
    @Description("Sending valid pet body to api point. Should receive code 200 and body with the same pet parameters")
    public void addPetPositiveTestShouldReturn200AndBodyEqualsToSent() {
        log.info("Start test with pet: {}", pet);
        Response response = PetRequest.addNewPet(pet);
        CommonChecks.checkResponseCode(HttpStatus.SC_OK, response);
        PetChecks.checkPetBody(pet, response);
    }

    @AfterEach
    public void deleteTestData() {
        PetRequest.deletePet(pet.getId());
        log.info("End of test");
    }

}
