package fr.polytech.Candidat.controllers;



import fr.polytech.Candidat.models.dto.LikeDTO;
import fr.polytech.Candidat.services.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriController {
    @Autowired
    private FavoriService favoriService;

    @PostMapping("/like")
    public ResponseEntity<String> likeCandidate(@RequestBody LikeDTO likeDTO) {
        String message = likeDTO.getIsLiked() ? "liked" : "disliked";
        try {
            favoriService.likeCandidate(likeDTO);
            return new ResponseEntity<>("Candidate "+message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Candidate is already "+message, HttpStatus.BAD_REQUEST);
        }
    }

}
