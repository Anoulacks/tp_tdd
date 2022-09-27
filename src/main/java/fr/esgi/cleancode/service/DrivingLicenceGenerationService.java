package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceGenerationService {

    private final SecurityNumberValidatorService serviceSecurityNumber;
    private final DrivingLicenceIdGenerationService serviceLicenceIdGeneration;
    private final InMemoryDatabase inMemoryDatabase;

    public DrivingLicence createNewDrivingLicence(String securityNumber) {
        UUID newUUID = serviceLicenceIdGeneration.generateNewDrivingLicenceId();
        if(serviceSecurityNumber.checkSecurityNumber(securityNumber)){
            DrivingLicence newDrivingLicence = DrivingLicence.builder().id(newUUID).build();
            return inMemoryDatabase.save(newDrivingLicence.getId(), newDrivingLicence);
        }
        return null;
    }
}
