package com.wellington.edu.model;

public enum Professions {
    GO_GO_BOY("Go Go Boy"),
    PROFESSOR("Professor"),
    ANARQUISTA("Anarquista"),
    RADIALISTA("Radialista"),
    PROGRAMADOR_FUDIDO("Programador fudido");

    private String profession;

    Professions(String profession) {
        this.profession = profession;
    }
}
