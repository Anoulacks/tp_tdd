package fr.esgi.cleancode.service;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;

public class SecurityNumberValidatorService {
    public boolean checkSecurityNumber (String securityNumber) {
        if(securityNumber != null && securityNumber.length() == 15 && securityNumber.matches("[0-9]+")) {
            return true;
        }

        throw new InvalidDriverSocialSecurityNumberException("Invalid Security Number");
    }
}
