package fr.polytech.Candidat.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CandidatListFactory {
    public static List<Candidat> getCandidatList() {
        return Arrays.asList(
                new Candidat(1L, "John", "Doe", 1, LocalDate.parse("1990-01-01"), "French",
                        new Candidat.Adresse(123L, "Main St", "12345", "Paris", "France"),
                        "johndoe@example.com", "123-456-7890", "url_to_photo", "url_to_cv", List.of("Dynamique", "Persévérant", "Communication"),
                        "A brief bio", LocalDate.of(2023,1,1), LocalDate.of(2023,12,31),
                        Arrays.asList(
                                new Candidat.Reference("Jane Smith", "XYZ Corp",
                                        new Candidat.Adresse(124L, "Second St", "12346", "Paris", "France"),
                                        "234-567-8901", "janesmith@example.com")
                ),
                        Arrays.asList(
                                new Candidat.Experience("Software Developer", "IT", LocalDate.parse("2015-06-01"), LocalDate.parse("2020-05-31"),
                                        new Candidat.Etablissement("ABC Inc",
                                                new Candidat.Adresse(125L, "Third St", "12347", "Paris", "France"))
                                )
                        )
                ),
                new Candidat(2L, "Alice", "Martin", 1, LocalDate.parse("1985-07-12"), "Canadian",
                        new Candidat.Adresse(45L, "Maple Street", "M4B 1B3", "Toronto", "Canada"),
                        "alicemartin@example.com", "416-555-1234", "url_to_photo_alice", "url_to_cv_alice", List.of("Dynamique", "Persévérant"),
                        "Experienced marketing professional", LocalDate.of(2022,9,1), LocalDate.of(2023,8,31),
                        Arrays.asList(
                                new Candidat.Reference("Bob Clark", "Marketing Inc",
                                        new Candidat.Adresse(46L, "Oak Street", "M4B 1B4", "Toronto", "Canada"),
                                        "416-555-5678", "bobclark@example.com")
                ),
                        Arrays.asList(
                                new Candidat.Experience("Marketing Manager", "Marketing", LocalDate.parse("2010-04-01"), LocalDate.parse("2020-08-31"),
                                        new Candidat.Etablissement("Creative Solutions",
                                                new Candidat.Adresse(47L, "Pine Street", "M4B 1B5", "Toronto", "Canada"))
                                )
                        )
                ),
                new Candidat(3L, "Hamou", "Mi", 0, LocalDate.parse("1992-11-30"), "British",
                        new Candidat.Adresse(10L, "High Street", "E1 6AN", "London", "United Kingdom"),
                        "mohamedali@example.com", "+44 20 7946 0912", "url_to_photo_mohamed", "url_to_cv_mohamed", List.of("Communication", "Organisation"),
                        "Software developer with a passion for mobile applications", LocalDate.of(2023,10,1), LocalDate.of(2024,9,30),
                        Arrays.asList(
                                new Candidat.Reference("Sarah Johnson", "Tech Innovations Ltd",
                                        new Candidat.Adresse(11L, "Queen Street", "E1 6AE", "London", "United Kingdom"),
                                        "+44 20 7946 0987", "sarahjohnson@example.com")
                ),
                        Arrays.asList(
                                new Candidat.Experience("Mobile Developer", "IT", LocalDate.parse("2016-09-01"), LocalDate.parse("2022-05-31"),
                                        new Candidat.Etablissement("Global Tech",
                                                new Candidat.Adresse(12L, "King Street", "E1 6AG", "London", "United Kingdom"))
                                )
                        )

                )
        );
    }
}
