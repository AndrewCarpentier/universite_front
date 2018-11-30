package fr.andrew.universite.universite_front.matiere.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Matiere {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numero")
    private Integer numeroMatiere;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("coef")
    private Integer coef;
    @JsonProperty("dateDebut")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateDebut;
    @JsonProperty("dateFin")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFin;
    private Enseignant enseignant;
    //private List<Note> notes;
}
