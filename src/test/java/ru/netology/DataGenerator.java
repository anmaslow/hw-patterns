package ru.netology;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    @Data
    @RequiredArgsConstructor
    public static class SubmitFormInfo {
        private final String lastName;
        private final String firstName;
        private final LocalDate firstDate;
        private final LocalDate secondDate;
        private final String phoneNumber;

        @Generated
        public static SubmitFormInfo generate(String locale) {

            Faker faker = new Faker(new Locale("ru"));

            return new SubmitFormInfo(
                    faker.name().lastName(),
                    faker.name().firstName(),
                    LocalDate.now().plusDays(4),
                    LocalDate.now().plusDays(5),
                    faker.numerify("7##########"));
        }
    }
}



