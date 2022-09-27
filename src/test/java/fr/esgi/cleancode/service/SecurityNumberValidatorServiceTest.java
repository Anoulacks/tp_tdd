package fr.esgi.cleancode.service;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CheckSecurityNumberServiceTest {

    @Test
    void isSecurityNumber() {
        final var securityNumber = "";
        assertThat(securityNumber)
                .isNotNull();
        throw new InvalidDriverSocialSecurityNumberException("Not valid");
    }


    @Test
    void should_find_securityNumber_not_null() {
        final var securityNumber = "";
        assertThat(securityNumber)
                .isNotNull();
    }

    @Test
    void should_find_securityNumber_type_integer() {
        final var securityNumber = "zioejoie";
        assertThat(securityNumber)
                .containsOnlyDigits();
        //throw new InvalidDriverSocialSecurityNumberException("Not integer");
    }

    @Test
    void should_find_securityNumber_size() {
        final var securityNumber = "azerty";
        assertThat(securityNumber).isEqualTo("15");

        //throw new InvalidDriverSocialSecurityNumberException("Not integer");
    }


}
