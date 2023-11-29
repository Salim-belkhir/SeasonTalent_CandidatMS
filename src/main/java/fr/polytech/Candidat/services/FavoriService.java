package fr.polytech.Candidat.services;


import fr.polytech.Candidat.models.Favori;
import fr.polytech.Candidat.models.dto.LikeDTO;
import fr.polytech.Candidat.repositories.FavoriRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriService {
    @Autowired
    private FavoriRepository favoriRepository;

    public Favori addFavori(Long idCandidat, Long idRecruteur) {
        Favori favori = new Favori(idCandidat, idRecruteur);
        return favoriRepository.save(favori);
    }

    public Favori getFavoriByIdCandidatAndIdRecruteur(Long idCandidat, Long idRecruteur) throws NotFoundException {
        return favoriRepository
                .findByIdCandidatAndIdRecruteur(idCandidat, idRecruteur)
                .orElseThrow(NotFoundException::new);
    }

    public boolean isLiked(Long idCandidat, Long idRecruteur) {
        return favoriRepository
                .findByIdCandidatAndIdRecruteur(idCandidat, idRecruteur)
                .isPresent();
    }

    public void likeCandidate(LikeDTO likeDTO) throws Exception {
        Favori favori = favoriRepository
                .findByIdCandidatAndIdRecruteur(likeDTO.getIdCandidat(), likeDTO.getIdRecruteur())
                .orElse(null);
        if(favori == null && likeDTO.getIsLiked()) {
            addFavori(likeDTO.getIdCandidat(), likeDTO.getIdRecruteur());
        }
        else if(favori != null && !likeDTO.getIsLiked()){
            favoriRepository.delete(favori);
        }
        else {
            throw new Exception();
        }
    }
}
