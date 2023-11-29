package fr.polytech.Candidat.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="emploi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emploi_id_seq")
    @SequenceGenerator(name = "emploi_id_seq", sequenceName = "emploi_id_seq", allocationSize = 1)
    private Long idEmploi;
    private String titre;
    private String descr;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long idEtablissement;

}
