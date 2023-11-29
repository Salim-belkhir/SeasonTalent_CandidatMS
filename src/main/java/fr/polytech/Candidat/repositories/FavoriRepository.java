package fr.polytech.Candidat.repositories;

import fr.polytech.Candidat.models.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    @Query("select f from Favori f where f.id.idCandidat = :idCandidat")
    Favori findByIdCandidat(@Param("idCandidat") Long idCandidat);

    @Query("select f from Favori f where f.id.idRecruteur = :idRecruteur")
    Favori findByIdRecruteur(@Param("idRecruteur") Long idRecruteur);
    
    
    @Query("select f from Favori f where f.id.idCandidat = :idCandidat and f.id.idRecruteur = :idRecruteur")
    Optional<Favori> findByIdCandidatAndIdRecruteur(@Param("idCandidat") Long idCandidat, @Param("idRecruteur") Long idRecruteur);
}
