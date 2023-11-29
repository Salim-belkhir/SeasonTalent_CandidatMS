package fr.polytech.Candidat.controllers;


import fr.polytech.Candidat.models.Candidat;
import fr.polytech.Candidat.models.dto.CandidatDTO;
import fr.polytech.Candidat.models.dto.OffreDTO;
import fr.polytech.Candidat.services.CandidatService;
import fr.polytech.Candidat.services.FavoriService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidates")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private FavoriService favoriService;

    @GetMapping("/all/{idRecruteur}")
    public ResponseEntity<List<CandidatDTO>> getAllCandidates(@PathVariable Long idRecruteur) {
        List<CandidatDTO> candidatsDTO = candidatService
                .getAllCandidates()
                .stream()
                .map(candidat -> new CandidatDTO(candidat, favoriService.isLiked(candidat.getId(), idRecruteur)))
                .toList();
        return ResponseEntity.ok(candidatsDTO);
    }

    @PostMapping("/recommendations/{idRecruteur}")
    public ResponseEntity<List<CandidatDTO>> getRecommendations(@RequestBody OffreDTO offre, @PathVariable Long idRecruteur) {
        if (offre == null) return ResponseEntity.badRequest().build();
        List<CandidatDTO> candidatsDTO = candidatService
                .getRecommendations(offre)
                .stream()
                .map(candidat -> new CandidatDTO(candidat, favoriService.isLiked(candidat.getId(), idRecruteur)))
                .toList();
        return ResponseEntity.ok(candidatsDTO);
    }

    @GetMapping("/{idCandidate}/{idRecruteur}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable Long id, @PathVariable Long idRecruteur) {
        try{
            Candidat candidat = candidatService.getCandidatById(id);
            CandidatDTO candidatDTO = new CandidatDTO(candidat, favoriService.isLiked(candidat.getId(), idRecruteur));
            return ResponseEntity.ok(candidatDTO);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
