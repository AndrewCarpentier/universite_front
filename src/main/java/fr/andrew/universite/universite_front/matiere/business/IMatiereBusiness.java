package fr.andrew.universite.universite_front.matiere.business;


import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;

import java.util.List;

public interface IMatiereBusiness {

    List<Matiere> findAll();
    Matiere findOneById(Integer id);
    Matiere add(Matiere matiere);
    Void modifier(Matiere matiere, Integer id);
    Void delete(Integer id);
    List<Enseignant> getEnseignant();

    Enseignant getEnseignantByID(Integer id);

}
