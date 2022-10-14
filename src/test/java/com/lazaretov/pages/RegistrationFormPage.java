package com.lazaretov.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //Elements

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper");


    //Actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
}
