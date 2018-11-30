package fr.andrew.universite.universite_front.etudiant.controller;

import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import org.springframework.ui.Model;

public interface IEtudiantController {

    String findAll(Model model);
    String findOneById(Model model, Integer id);
    String add(Model model);
    String addPost(Etudiant etudiant);
    String delete(Integer id);
    String modifier(Model model, Integer id);
    String modifierPost(Etudiant etudiant);
    String note(Model model, Integer id);

}
