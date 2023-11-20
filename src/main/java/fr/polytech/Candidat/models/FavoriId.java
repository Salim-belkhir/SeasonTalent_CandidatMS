package fr.polytech.Candidat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriId  implements Serializable {
    @Column(name = "id_candidat")
    private Long idCandidat;

    @Column(name = "id_emploi")
    private Long idEmploi;
}
