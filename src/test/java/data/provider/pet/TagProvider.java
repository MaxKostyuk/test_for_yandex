package data.provider.pet;

import models.pet.Tag;

import java.util.stream.Stream;

public class TagProvider {
    private static final int VALID_TAG_ID = 100;
    private static final String VALID_TAG_NAME = "TestTag";

    public static Stream<Tag> singleValidTagProvider() {
        return Stream.of(new Tag(VALID_TAG_ID, VALID_TAG_NAME));
    }
}
