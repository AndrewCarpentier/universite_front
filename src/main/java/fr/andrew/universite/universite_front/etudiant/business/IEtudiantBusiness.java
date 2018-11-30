package fr.andrew.universite.universite_front.etudiant.business;

import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;

import java.util.List;

public interface IEtudiantBusiness {

    List<Etudiant> findAll();
    Etudiant findOneById(Integer id);
    Etudiant add(Etudiant etudiant);
    Void modifier(Etudiant etudiant, Integer id);
    Void delete(Integer id);


}
