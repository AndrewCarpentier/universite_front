package fr.andrew.universite.universite_front.matiere.repository;

import fr.andrew.universite.universite_front.matiere.domain.Matiere;

import java.util.List;

public interface IMatiereRepository{

    List<Matiere> findAll();
    Matiere getOne(Integer id);
    Matiere add(Matiere etudiant);
    Void update(Matiere etudiant, Integer id);
    Void delete(Integer id);


}
