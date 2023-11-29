package fr.polytech.Candidat.repositories;

import fr.polytech.Candidat.models.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, Long> {
    List<Avis> findByIdCandidat(Long idCandidat);
    List<Avis> findByIdRecruteur(Long idRecruteur);

    @Query("SELECT a FROM Avis a WHERE a.emploi.idEmploi = :idEmploi")
    Avis findByIdEmploi(@Param("idEmploi") Long idEmploi);
}
