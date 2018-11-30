package fr.andrew.universite.universite_front.note.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import lombok.Data;

@Data
public class Note {

    private NotePk notePk;
    @JsonProperty("note")
    private Double noteValue;
    private Etudiant etudiant;
    private Matiere matiere;

}
