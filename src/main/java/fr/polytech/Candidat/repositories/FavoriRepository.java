package fr.polytech.Candidat.repositories;

import fr.polytech.Candidat.models.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    @Query("select f from favoris f where f.idCandidat = :idCandidat")
    Favori findByIdCandidat(@Param("idCandidat") Long idCandidat);

    @Query("select f from favoris f where f.idEmploi = :idEmploi")
    Favori findByIdRecruteur(@Param("idEmploi") Long idEmploi);
}
