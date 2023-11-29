package fr.polytech.Candidat.services;


import fr.polytech.Candidat.models.Avis;
import fr.polytech.Candidat.repositories.AvisRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    @Autowired
    private AvisRepository avisRepository;

    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    public List<Avis> getAvisByCandidateId(Long id) {
        return avisRepository.findByIdCandidat(id);
    }

    public Avis getAvisById(Long id) throws NotFoundException {
        return avisRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Avis createAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    public void deleteAvis(Long id) throws NotFoundException {
        Avis avis = avisRepository.findById(id).orElseThrow(NotFoundException::new);
        avisRepository.delete(avis);
    }
}
