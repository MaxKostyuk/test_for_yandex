package tests.pet.get;
import cheks.CommonChecks;
import cheks.PetChecks;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.pet.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import requests.PetRequest;
import tests.BaseTestClass;

import static data.provider.pet.PetProvider.singleValidPetProvider;

@Slf4j
@DisplayName("Get pet by id api test")
public class GetPetByIdTest extends BaseTestClass {

    private static Pet pet;

    @BeforeAll
    public static void setUp() {
        pet = singleValidPetProvider().findAny().get();
    }

    @BeforeEach
    public void addPetSetup() {
        PetRequest.addNewPet(pet);
    }

    @Test
    @DisplayName("Positive test for get pet")
    public void getPetByIdPositiveTestShouldReturn200AndExpectedPetBody() {
        log.info("Start test with pet {}", pet);
        Response response = PetRequest.getPetById(pet.getId());
        CommonChecks.checkResponseCode(HttpStatus.SC_OK, response);
        PetChecks.checkPetBody(pet, response);
    }

    @AfterEach
    public void deleteTestData() {
        PetRequest.deletePet(pet.getId());
        log.info("End of test");
    }
}
