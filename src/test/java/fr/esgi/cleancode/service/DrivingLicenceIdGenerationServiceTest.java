package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DrivingLicenceIdGenerationServiceTest {
    @InjectMocks
    private DrivingLicenceIdGenerationService serviceLicenceIdGeneration;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_generate_valid_UUID() {
        final var actual = serviceLicenceIdGeneration.generateNewDrivingLicenceId();
        assertThat(actual)
                .isNotNull()
                .isEqualTo(UUID.fromString(actual.toString()));
    }

}