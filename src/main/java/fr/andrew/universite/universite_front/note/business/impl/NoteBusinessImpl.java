package fr.andrew.universite.universite_front.note.business.impl;

import fr.andrew.universite.universite_front.etudiant.business.IEtudiantBusiness;
import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.matiere.business.IMatiereBusiness;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.note.business.INoteBusiness;
import fr.andrew.universite.universite_front.note.domain.Note;
import fr.andrew.universite.universite_front.note.repository.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteBusinessImpl implements INoteBusiness {
    @Autowired
    private INoteRepository noteRepository;

    @Autowired
    private IEtudiantBusiness etudiantBusiness;

    @Autowired
    private IMatiereBusiness matiereBusiness;

    @Override
    public List<Note> finddAll() {

        return noteRepository.findAll();
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.add(note);
    }

    @Override
    public List<Etudiant> getEtudiant() {
        return etudiantBusiness.findAll();
    }

    @Override
    public List<Matiere> getMatiere() {
        return matiereBusiness.findAll();
    }


}
