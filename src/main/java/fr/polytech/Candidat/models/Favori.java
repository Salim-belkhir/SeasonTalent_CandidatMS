package fr.polytech.Candidat.models;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "favoris")
public class Favori {
    @EmbeddedId
    private FavoriId id;

    public Favori() {
        this.id = new FavoriId();
    }

    public Favori(Long idCandidat, Long idRecruteur) {
        this.id = new FavoriId(idCandidat, idRecruteur);
    }


    public Long getIdCandidat() {
        return this.id.getIdCandidat();
    }

    public void setIdCandidat(Long idCandidat) {
        this.id.setIdCandidat(idCandidat);
    }

    public Long getIdRecruteur() {
        return this.id.getIdRecruteur();
    }

    public void setIdRecruteur(Long idRecruteur) {
        this.id.setIdRecruteur(idRecruteur);
    }
}
