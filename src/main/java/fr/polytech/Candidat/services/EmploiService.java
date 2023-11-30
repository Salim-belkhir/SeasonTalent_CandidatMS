package fr.polytech.Candidat.services;

import fr.polytech.Candidat.models.Emploi;
import fr.polytech.Candidat.repositories.EmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploiService {

    @Autowired
    private EmploiRepository emploiRepository;

    public Emploi getEmploiById(Long id) {
        return emploiRepository.findById(id).orElse(null);
    }

    public List<Emploi> getAllEmplois() {
        return emploiRepository.findAll();
    }

    public Emploi addEmploi(Emploi emploi) {
        if(emploi == null || emploi.getTitre() == null || emploi.getDateDebut() == null
            || emploi.getDateFin() == null || emploi.getIdEtablissement() == null){
            return null;
        }
        return emploiRepository.save(emploi);
    }

    public Emploi updateEmploi(Long idEmploi, Emploi emploi) {
        Emploi emploiToUpdate = emploiRepository.findById(idEmploi).orElse(null);
        if(emploiToUpdate == null){
            return null;
        }
        if(emploi.getTitre() != null){
            emploiToUpdate.setTitre(emploi.getTitre());
        }
        if(emploi.getDescr() != null){
            emploiToUpdate.setDescr(emploi.getDescr());
        }
        if(emploi.getDateDebut() != null){
            emploiToUpdate.setDateDebut(emploi.getDateDebut());
        }
        if(emploi.getDateFin() != null){
            emploiToUpdate.setDateFin(emploi.getDateFin());
        }
        if(emploi.getIdEtablissement() != null){
            emploiToUpdate.setIdEtablissement(emploi.getIdEtablissement());
        }

        return emploiRepository.save(emploiToUpdate);
    }

    public Boolean deleteEmploi(Long idEmploi) {
        boolean isDeleted = false;
        if(emploiRepository.existsById(idEmploi)){
            emploiRepository.deleteById(idEmploi);
            isDeleted = true;
        }
        return isDeleted;
    }
}
