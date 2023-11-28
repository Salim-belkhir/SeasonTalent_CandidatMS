package fr.polytech.Candidat.services;


import fr.polytech.Candidat.models.Candidat;
import fr.polytech.Candidat.models.CandidatListFactory;
import fr.polytech.Candidat.models.dto.OffreDTO;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CandidatService {
    private final List<Candidat> candidatList = CandidatListFactory.getCandidatList();

    public List<Candidat> getRecommendations(OffreDTO offre) {

        List<Candidat> candidatsSuggested = new ArrayList<>();
        for (Candidat candidat : this.candidatList) {

            LocalDate debutCandidat = candidat.getStartDispo();
            LocalDate finCandidat = candidat.getEndDispo();

            LocalDate debutOffre = offre.getDateDebut();
            LocalDate finOffre = offre.getDateFin();

            String villeCandidat = candidat.getAddress().getCity();
            String villeOffre = offre.getVille();

            List<String> competencesCandidat = candidat.getCompetences();
            List<String> competencesOffre = offre.getCompetencesRequises();

            if (!debutCandidat.isAfter(finOffre) && !finCandidat.isBefore(debutOffre)){
                if (villeCandidat.equalsIgnoreCase(villeOffre)) {
                    if (new HashSet<>(competencesCandidat).containsAll(competencesOffre)) {
                        // peut-etre ajouter un if qui va regarder dans les experiences déjà effectué par le candidat
                        // si il y a une experience similaire qui correspond à l'offre
                        candidatsSuggested.add(candidat);
                    }
                }
            }
        }
        return candidatsSuggested;
    }

    public List<Candidat> getAllCandidates() {
        return this.candidatList;
    }

    public Candidat getCandidatById(Long id) throws NotFoundException {
        return this.candidatList.stream()
                .filter(c -> c.getId().equals(id)).findFirst()
                .orElseThrow(NotFoundException::new);
    }

}
