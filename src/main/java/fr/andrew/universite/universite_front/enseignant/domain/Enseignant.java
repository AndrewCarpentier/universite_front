package fr.andrew.universite.universite_front.enseignant.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;

@Data
public class Enseignant {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numero")
    private Integer numeroEnseignant;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("dateNaissance")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;
    @JsonProperty("sexe")
    private String sexe;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("dateEmbauche")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateEmbauche;
    private List<Matiere> matieres;

}
