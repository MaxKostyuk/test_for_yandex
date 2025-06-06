package data.provider.pet;

import models.pet.Category;

import java.util.stream.Stream;

public class CategoryProvider {
    private static final int VALID_CATEGORY_ID = 200;
    private static final String VALID_CATEGORY_NAME = "TestCategory";

    public static Stream<Category> singleValidCategoryProvider() {
        return Stream.of(new Category(VALID_CATEGORY_ID, VALID_CATEGORY_NAME));
    }
}
