package fr.polytech.Candidat.controllers;


import fr.polytech.Candidat.models.Avis;
import fr.polytech.Candidat.services.AvisService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avis")
public class AvisController {
    @Autowired
    private AvisService avisService;

    @GetMapping("")
    public ResponseEntity<List<Avis>> getAllAvis() {
        List<Avis> avis = avisService.getAllAvis();
        return new ResponseEntity<>(avis, HttpStatus.OK);
    }

    @GetMapping("/candidate/{id}")
    public ResponseEntity<List<Avis>> getAvisByCandidateId(@PathVariable Long id) {
        List<Avis> avis = avisService.getAvisByCandidateId(id);
        HttpStatus status = avis.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(avis, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable Long id) {
        try {
            Avis avis = avisService.getAvisById(id);
            return new ResponseEntity<>(avis, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Avis> createAvis(@RequestBody Avis avis) {
        Avis newAvis = avisService.createAvis(avis);
        HttpStatus status = newAvis == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED;
        return new ResponseEntity<>(newAvis, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Avis> deleteAvis(@PathVariable Long id) {
        try {
            avisService.deleteAvis(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
