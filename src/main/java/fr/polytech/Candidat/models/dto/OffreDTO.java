package fr.polytech.Candidat.models.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Value
@Getter
@Setter
@AllArgsConstructor
public class OffreDTO {
    private Long idOffre;
    private String titre;
    private String descr;
    private List<String> competencesRequises;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String salaire;
    private String avantages;
    private String ville;
}
