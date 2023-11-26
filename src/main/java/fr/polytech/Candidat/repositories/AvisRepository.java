package fr.polytech.Candidat.repositories;

import fr.polytech.Candidat.models.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvisRepository extends JpaRepository<Avis, Long> {
    Avis findByIdCandidat(Long idCandidat);
    Avis findByIdRecruteur(Long idRecruteur);
    Avis findByIdAvis(Long idAvis);

    @Query("SELECT a FROM Avis a WHERE a.emploi.idEmploi = :idEmploi")
    Avis findByIdEmploi(@Param("idEmploi") Long idEmploi);
}
