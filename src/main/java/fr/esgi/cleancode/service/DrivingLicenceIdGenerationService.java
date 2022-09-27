package fr.esgi.cleancode.service;

import fr.esgi.cleancode.model.DrivingLicence;

import java.util.UUID;

public class DrivingLicenceIdGenerationService {

    public UUID generateNewDrivingLicenceId() {
        return UUID.randomUUID();
    }


}
