package fr.polytech.Candidat.repositories;

import fr.polytech.Candidat.models.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploiRepository  extends JpaRepository<Emploi, Long> {
    Emploi findByIdEtablissement(Long idEtablissement);
}
