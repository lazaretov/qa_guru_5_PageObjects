package com.lazaretov.tests;

import com.codeborne.selenide.Configuration;
import com.lazaretov.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormWithObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest () {
        String firstName = "Dude";
        String lastName = "Random";
        String email = "random@dude.ai";
        String phone = "8800555353";
        String subject = "English";
        String state = "Haryana";
        String city = "Karnal";
        String addres = "textExample";
        String hobby = "Reading";
        String gender = "Female";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender);

        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("pic.JPG");
        $("#currentAddress").setValue(addres);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();


        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(phone),
                text("28 September,1991"),
                text(subject),
                text(hobby),
                text(addres),
                text("pic.JPG"),
                text(state + " " + city));
    }
}
