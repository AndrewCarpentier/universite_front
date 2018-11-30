package fr.andrew.universite.universite_front.note.controller;


import fr.andrew.universite.universite_front.note.domain.Note;
import org.springframework.ui.Model;

public interface INoteController {

    String findAll(Model model);

    String addNote(Model model);
    String addPost(Note note, Integer idEtudiant, Integer idMatiere);
}
