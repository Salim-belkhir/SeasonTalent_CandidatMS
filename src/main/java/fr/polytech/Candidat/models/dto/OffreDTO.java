package fr.polytech.Candidat.models.dto;


import lombok.*;

import java.time.LocalDate;

@Value
@Getter
@Setter
@AllArgsConstructor
public class OffreDTO {
    private Long idOffre;
    private String titre;
    private String descr;
    private String competences;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String salaire;
    private String avantages;
    private String ville;
}
