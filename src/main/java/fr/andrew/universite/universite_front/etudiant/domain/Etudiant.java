package fr.andrew.universite.universite_front.etudiant.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.andrew.universite.universite_front.note.domain.Note;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;

@Data
public class Etudiant {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numero")
    private Integer numeroEtudiant;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("dateNaissance")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;
    @JsonProperty("sexe")
    private String sexe;
    private List<Note> notes;

}
