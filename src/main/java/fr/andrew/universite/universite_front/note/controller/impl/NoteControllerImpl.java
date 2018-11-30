package fr.andrew.universite.universite_front.note.controller.impl;

import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.note.business.INoteBusiness;
import fr.andrew.universite.universite_front.note.controller.INoteController;
import fr.andrew.universite.universite_front.note.domain.Note;
import fr.andrew.universite.universite_front.note.domain.NotePk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoteControllerImpl implements INoteController {

    @Autowired
    private INoteBusiness noteBusiness;

    private static String getRedirectNote = "redirect:/note";

    @Override
    @GetMapping(path = "/note", name = "note")
    public String findAll(Model model) {
        model.addAttribute("note", noteBusiness.finddAll());

        return "/note/note";
    }

    @Override
    @GetMapping(path = "/note/add", name = "ajouter")
    public String addNote(Model model) {
        List<Etudiant> etudiants = noteBusiness.getEtudiant();
        List<Matiere> matieres = noteBusiness.getMatiere();
        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("matieres", matieres);

        return "/note/noteAdd";
    }

    @Override
    @PostMapping(path = "/note/add", name = "ajouter")
    public String addPost(@ModelAttribute Note note, @RequestParam Integer idEtudiant, @RequestParam Integer idMatiere) {
        NotePk notePk = new NotePk();
        notePk.setEtudiant(idEtudiant);
        notePk.setMatiere(idMatiere);
        note.setNotePk(notePk);

        noteBusiness.addNote(note);

        return getRedirectNote;
    }
}
