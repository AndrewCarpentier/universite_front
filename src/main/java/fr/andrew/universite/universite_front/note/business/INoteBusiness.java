package fr.andrew.universite.universite_front.note.business;


import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.note.domain.Note;

import java.util.List;

public interface INoteBusiness {

    List<Note> finddAll();
    Note addNote(Note note);
    List<Etudiant> getEtudiant();
    List<Matiere> getMatiere();

}


