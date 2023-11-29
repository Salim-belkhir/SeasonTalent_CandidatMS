package fr.polytech.Candidat.models.dto;


import lombok.*;

@Value
@Getter
@Setter
@AllArgsConstructor
public class LikeDTO {
    private Long idCandidat;
    private Long idRecruteur;
    private Boolean isLiked;
}
