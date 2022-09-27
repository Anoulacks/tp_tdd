package fr.esgi.cleancode.service;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class SecurityNumberValidatorServiceTest {

    private final SecurityNumberValidatorService service = new SecurityNumberValidatorService();

    @Test
    void should_valid_securityNumber() {
        final var securityNumber = "123456789012345";
        assertThat(service.checkSecurityNumber(securityNumber)).isTrue();
    }

    @Test
    void should_invalid_securityNumber() {
        final var securityNumber = "azer";
        assertThat(service.checkSecurityNumber(securityNumber)).isTrue();
    }



}
