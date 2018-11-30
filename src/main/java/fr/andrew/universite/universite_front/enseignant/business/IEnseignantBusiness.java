package fr.andrew.universite.universite_front.enseignant.business;

import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;

import java.util.List;

public interface IEnseignantBusiness {

    List<Enseignant> findAll();
    Enseignant findOneById(Integer id);
    Enseignant add(Enseignant enseignant);
    Void delete(Integer id);
    Void modifier(Enseignant enseignant, Integer id);

}
