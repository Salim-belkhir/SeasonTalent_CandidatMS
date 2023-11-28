package fr.polytech.Candidat.models;

import lombok.*;

import java.util.List;

@Value
@Getter
@Setter
@AllArgsConstructor
public class Candidat {
    Long id;
    String firstname;
    String lastname;
    int gender;
    String birthDate;
    String citizenship;
    Adresse address;
    String email;
    String phone;
    String photo;
    String cv;
    String shortBio;
    List<Reference> references;
    List<Experience> experiences;
    List<Availability> availabilities;



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
        String startedAt;
        String endedAt;
        Etablissement establishment;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Availability {
        String job;
        String jobCategory;
        String startsAt;
        String endsAt;
        List<String> places;
    }

}