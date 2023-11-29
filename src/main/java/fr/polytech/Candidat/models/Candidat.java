package fr.polytech.Candidat.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Candidat {
    Long id;
    String firstname;
    String lastname;
    int gender;
    LocalDate birthDate;
    String citizenship;
    Adresse address;
    String email;
    String phone;
    String photo;
    String cv;
    List<String> competences;
    String shortBio;
    LocalDate startDispo;
    LocalDate endDispo;
    List<Reference> references;
    List<Experience> experiences;



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Adresse {
        Long streetNum;
        String street;
        String zipCode;
        String city;
        String country;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Reference {
        String refName;
        String refEstablishment;
        Adresse refAddress;
        String refPhone;
        String refEmail;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Etablissement {
        String establishmentName;
        Adresse establishmentAddress;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Experience {
        String job;
        String jobCategory;
        LocalDate startedAt;
        LocalDate endedAt;
        Etablissement establishment;
    }



}