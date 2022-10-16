package com.lazaretov.tests;

import com.codeborne.selenide.Configuration;
import com.lazaretov.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        registrationFormPage.openPage()
                .setFirstName("Dude")
                .setLastName("Random")
                .setEmail("random@dude.ai")
                .setGender("Female")
                .setPhone("8800555353")
                .setDateOfBirth("28", "September", "1991")
                .setSubjects("English")
                .setHobbies("Reading")
                .uploadPic("pic.JPG")
                .setAddress("textExample", "Haryana", "Karnal")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Dude Random")
                .checkResult("Student Email", "random@dude.ai")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800555353")
                .checkResult("Date of Birth", "28 September,1991")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "pic.JPG")
                .checkResult("Address", "textExample")
                .checkResult("State and City", "Haryana Karnal");


    }
}
