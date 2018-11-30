package fr.andrew.universite.universite_front.enseignant.repository;

import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEnseignantRepository{

    List<Enseignant> findAll();
    Enseignant  getOne(Integer id);
    Enseignant add(Enseignant enseignant);
    Void update(Enseignant enseignant, Integer id);
    Void deleteById(Integer id);

}
