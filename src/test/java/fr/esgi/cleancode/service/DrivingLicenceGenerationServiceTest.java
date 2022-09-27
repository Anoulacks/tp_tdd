package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DrivingLicenceGenerationServiceTest {


    @InjectMocks
    private DrivingLicenceGenerationService serviceLicenceGeneration;
    private DrivingLicenceIdGenerationService serviceLicenceIdGeneration;
    private SecurityNumberValidatorService serviceSecurityNumber;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_have_total_points() {
        final var securityNumber = "123456789012345";
        final var drivingLicence = serviceLicenceGeneration.createNewDrivingLicence(securityNumber);
        assertThat(drivingLicence.getAvailablePoints()).isEqualTo(12);
    }

    @Test
    void should_generate_licence() {
        final var securityNumber = "123456789012345";
        final var uuid = serviceLicenceIdGeneration.generateNewDrivingLicenceId();
        final var drivingLicence = serviceLicenceGeneration.createNewDrivingLicence(securityNumber);
        when(serviceSecurityNumber.checkSecurityNumber(securityNumber)).thenReturn(true);
        when(uuid).thenReturn(uuid);
        when(database.save(drivingLicence.getId(), drivingLicence)).thenReturn(drivingLicence);
        final var actual = database.save(uuid, drivingLicence);
        assertThat(drivingLicence).isEqualTo(actual);
    }
}
