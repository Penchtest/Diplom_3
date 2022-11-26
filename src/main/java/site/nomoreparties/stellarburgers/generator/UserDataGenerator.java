package site.nomoreparties.stellarburgers.generator;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {
    @Step("Generate correct user data for registration")
    public static UserData getRandomUserData() {
        UserData userData = new UserData();
        Faker faker = new Faker();
        userData.setEmail(faker.internet().emailAddress());
        userData.setPassword(RandomStringUtils.randomAlphanumeric(7));
        userData.setName(faker.name().name());
        return userData;
    }

    @Step("Generate user data with invalid password")
    public static UserData getRandomUserDataWithInvalidPassword() {
        UserData userData = new UserData();
        Faker faker = new Faker();
        userData.setEmail(faker.internet().emailAddress());
        userData.setPassword(RandomStringUtils.randomAlphanumeric(5));
        userData.setName(faker.name().name());
        return userData;
    }
}
