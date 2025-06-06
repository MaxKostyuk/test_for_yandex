package tests.pet.update;

import cheks.CommonChecks;
import cheks.PetChecks;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.pet.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import requests.PetRequest;
import tests.BaseTestClass;

import static data.provider.pet.PetProvider.singleValidPetProvider;
import static data.provider.pet.PetProvider.singleValidPetWithName;

@Slf4j
@DisplayName("Update pet api test")
public class UpdatePetTest extends BaseTestClass {

    private static Pet pet;
    private static Pet updatedPet;

    @BeforeAll
    public static void setUp() {
        pet = singleValidPetProvider();
        updatedPet = singleValidPetWithName("updatedName");
    }

    @BeforeEach
    public void addPetSetup() {
        PetRequest.addNewPet(pet);
    }

    @Test
    @DisplayName("Positive test for update pet")
    @Description("Should return code 200 and body with the same pet as sent for update")
    public void updatePetPositiveTestShouldReturn200AndExpectedPetBody() {
        log.info("Start test with updated pet {} ", updatedPet);
        Response response = PetRequest.updatePet(updatedPet);
        CommonChecks.checkResponseCode(HttpStatus.SC_OK, response);
        PetChecks.checkPetBody(updatedPet, response);
    }

    @AfterEach
    public void deleteTestData() {
        PetRequest.deletePet(pet.getId());
        log.info("End of test");
    }
}
