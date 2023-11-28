package fr.polytech.Candidat.controllers;


import fr.polytech.Candidat.models.Candidat;
import fr.polytech.Candidat.models.dto.OffreDTO;
import fr.polytech.Candidat.services.CandidatService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;


    @GetMapping("/")
    public ResponseEntity<List<Candidat>> getAllCandidates() {
        List<Candidat> candidats = candidatService.getAllCandidates();
        return ResponseEntity.ok(candidats);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<Candidat>> getRecommendations(OffreDTO offre) {
        List<Candidat> candidats = candidatService.getRecommendations(offre);
        return ResponseEntity.ok(candidats);
    }

    @GetMapping("{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable Long id) {
        try{
            Candidat candidat = candidatService.getCandidatById(id);
            return ResponseEntity.ok(candidat);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
