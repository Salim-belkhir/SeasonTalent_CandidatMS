package fr.polytech.Candidat.controllers;

import fr.polytech.Candidat.models.Emploi;
import fr.polytech.Candidat.services.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplois")
public class EmploiController {

    @Autowired
    private EmploiService emploiService;

    @GetMapping("")
    public ResponseEntity<List<Emploi>> getAllEmplois() {
        List<Emploi> emplois = emploiService.getAllEmplois();
        HttpStatus status = emplois != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(emplois, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emploi> getEmploiById(@PathVariable Long id) {
        Emploi emploi = emploiService.getEmploiById(id);
        HttpStatus status = emploi != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(emploi, status);
    }

    @PostMapping("/")
    public ResponseEntity<Emploi> addEmploi(@RequestBody Emploi emploi) {
        if (emploi == null) return ResponseEntity.badRequest().build();
        Emploi newEmploi = emploiService.addEmploi(emploi);
        HttpStatus status = newEmploi != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(newEmploi, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emploi> updateEmploi(@PathVariable Long id, @RequestBody Emploi emploi) {
        if (emploi == null) return ResponseEntity.badRequest().build();
        Emploi updatedEmploi = emploiService.updateEmploi(id, emploi);
        HttpStatus status = updatedEmploi != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(updatedEmploi, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploi(@PathVariable Long id) {
        Boolean isDeleted = emploiService.deleteEmploi(id);
        HttpStatus status = isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }
}
