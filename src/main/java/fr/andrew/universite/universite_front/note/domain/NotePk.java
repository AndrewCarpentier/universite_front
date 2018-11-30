package fr.andrew.universite.universite_front.note.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class NotePk implements Serializable {
    @JsonProperty("idEtudiant")
    private Integer etudiant;
    @JsonProperty("idMatiere")
    private Integer matiere;

}
