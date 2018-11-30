package fr.andrew.universite.universite_front.matiere.controller;

import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import org.springframework.ui.Model;

public interface IMatiereController {

   String findAll(Model model);
   String findOneById(Model model, Integer id);
   String add(Model model);
   String addPost(Matiere matiere, Integer idEnseignant);
   String delete(Integer id);
   String modifier(Model model, Integer id);
   String modifierPost(Matiere matiere, Integer idEnseignant);

}
