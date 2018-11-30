package fr.andrew.universite.universite_front.etudiant.repository;

import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;

import java.util.List;

public interface IEtudiantRepository  {

    List<Etudiant> findAll();
    Etudiant getOne(Integer id);
    Etudiant add(Etudiant etudiant);
    Void delete(Integer id);
    Void update(Etudiant etudiant, Integer id);
}
