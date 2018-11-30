package fr.andrew.universite.universite_front.note.repository;

import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.note.domain.Note;

import java.util.List;

public interface INoteRepository{

    List<Note> findAll();
    Note add(Note note);
}
