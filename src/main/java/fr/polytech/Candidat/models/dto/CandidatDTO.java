package fr.polytech.Candidat.models.dto;

import fr.polytech.Candidat.models.Candidat;

import java.time.LocalDate;
import java.util.List;




public class CandidatDTO extends Candidat {
    private boolean isFavorite;

    public CandidatDTO(Long id, String firstname, String lastname, int gender, LocalDate birthDate, String citizenship, Adresse address, String email, String phone, String photo, String cv, List<String> competences, String shortBio, LocalDate startDispo, LocalDate endDispo, List<Reference> references, List<Experience> experiences, boolean isFavorite) {
        super(id, firstname, lastname, gender, birthDate, citizenship, address, email, phone, photo, cv, competences, shortBio, startDispo, endDispo, references, experiences);
        this.isFavorite = isFavorite;
    }

    public CandidatDTO(Candidat candidat, boolean isFavorite) {
        super(candidat.getId(), candidat.getFirstname(), candidat.getLastname(), candidat.getGender(), candidat.getBirthDate(), candidat.getCitizenship(), candidat.getAddress(), candidat.getEmail(), candidat.getPhone(), candidat.getPhoto(), candidat.getCv(), candidat.getCompetences(), candidat.getShortBio(), candidat.getStartDispo(), candidat.getEndDispo(), candidat.getReferences(), candidat.getExperiences());
        this.isFavorite = isFavorite;
    }
}
