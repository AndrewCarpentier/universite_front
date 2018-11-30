package fr.andrew.universite.universite_front.matiere.controller.impl;

import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import fr.andrew.universite.universite_front.matiere.business.IMatiereBusiness;
import fr.andrew.universite.universite_front.matiere.controller.IMatiereController;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MatiereControllerImpl implements IMatiereController {

    @Autowired
    private IMatiereBusiness matiereBusiness;

    private static Enseignant enseignant = new Enseignant();
    private static String getRedirectMatiere = "redirect:/matiere";

    @Override
    @GetMapping(path = "/matiere", name = "matiere")
    public String findAll(Model model) {
        List<Matiere> matieres = matiereBusiness.findAll();
        model.addAttribute("matieres", matieres);

        return "/matiere/matiere";
    }

    @Override
    @GetMapping(path = "/matiere/detail", name = "detail")
    public String findOneById(Model model, @RequestParam Integer id) {
        Matiere matiere = matiereBusiness.findOneById(id);
        model.addAttribute("matiereDetail", matiere);

        return "/matiere/matiereDetail";
    }

    @Override
    @GetMapping(path = "/matiere/add", name = "add")
    public String add(Model model) {
        List<Enseignant> enseignants = matiereBusiness.getEnseignant();
        model.addAttribute("matiereAdd", new Matiere());
        model.addAttribute("enseignants", enseignants);

        return "/matiere/matiereAdd";
    }

    @Override
    @PostMapping(path = "/matiere/add", name = "add")
    public String addPost(@ModelAttribute Matiere matiere, @RequestParam(name = "idEnseignant")Integer idEnseignant) {
        enseignant.setId(idEnseignant);
        matiere.setEnseignant(enseignant);
        matiereBusiness.add(matiere);

        return getRedirectMatiere;
    }

    @Override
    @GetMapping(path = "/matiere/delete", name = "delete")
    public String delete(Integer id) {
        matiereBusiness.delete(id);

        return getRedirectMatiere;
    }

    @Override
    @GetMapping(path = "matiere/modifier", name = "modifier")
    public String modifier(Model model, @RequestParam Integer id) {
        List<Enseignant> enseignant = matiereBusiness.getEnseignant();
        Matiere matiere = matiereBusiness.findOneById(id);
        model.addAttribute("matiereModifier", matiere);
        model.addAttribute("enseignants", enseignant);

        return "/matiere/matiereModifier";
    }

    @Override
    @PostMapping(path = "matiere/modifier", name = "modifier")
    public String modifierPost(@ModelAttribute Matiere matiere, @RequestParam(name = "idEnseignant") Integer idEnseignant) {
        enseignant.setId(idEnseignant);
        matiere.setEnseignant(enseignant);
        matiereBusiness.modifier(matiere, matiere.getId());

        return getRedirectMatiere;
    }


}
