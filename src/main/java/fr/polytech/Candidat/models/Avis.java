package fr.polytech.Candidat.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avis")
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avis_id_seq")
    @SequenceGenerator(name = "avis_id_seq", sequenceName = "avis_id_seq", allocationSize = 1)
    private Long idAvis;
    private int note;
    private String commentaire;
    private Long idCandidat;
    private Long idRecruteur;
    @OneToOne
    @JoinColumn(name = "idEmploi")
    private Emploi emploi;

}
