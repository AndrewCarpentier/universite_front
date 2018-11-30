package fr.andrew.universite.universite_front.enseignant.controller.impl;

import fr.andrew.universite.universite_front.enseignant.business.IEnseignantBusiness;
import fr.andrew.universite.universite_front.enseignant.controller.IEnseignantController;
import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EnseignantControllerImpl implements IEnseignantController {

    @Autowired
    private IEnseignantBusiness enseignantBusiness;

    private static String getRedirectEnseignant = "redirect:/enseignant";

    @Override
    @GetMapping(path = "/enseignant", name = "enseignant")
    public String findAll(Model model) {
        List<Enseignant> enseignants = enseignantBusiness.findAll();
        model.addAttribute("enseignants", enseignants);

        return "enseignant/enseignant";
    }

    @Override
    @GetMapping(path = "/enseignant/detail", name = "detail")
    public String findOneById(Model model, @RequestParam Integer id) {
        Enseignant enseignantById = enseignantBusiness.findOneById(id);
        model.addAttribute("enseignantDetail", enseignantById);

        return "enseignant/enseignantDetail";
    }

    @Override
    @GetMapping(path = "/enseignant/add", name = "add")
    public String add(Model model) {
        Enseignant enseignant = new Enseignant();
        enseignant.setSexe("M");
        model.addAttribute("enseignantAdd", enseignant);


        return "enseignant/enseignantAdd";
    }

    @Override
    @PostMapping(path = "/enseignant/add", name = "add")
    public String addPost(@ModelAttribute Enseignant enseignantAdd) {
        enseignantBusiness.add(enseignantAdd);

        return getRedirectEnseignant;
    }

    @Override
    @GetMapping(path = "/enseignant/delete", name = "delete")
    public String delete(@RequestParam Integer id) {
        enseignantBusiness.delete(id);

        return getRedirectEnseignant;
    }

    @Override
    @GetMapping(path = "/enseignant/modifier", name = "modifier")
    public String modifier(Model model, @RequestParam Integer id) {
        Enseignant enseignantById2 = enseignantBusiness.findOneById(id);

        model.addAttribute("enseignantModifier", enseignantById2);
        return "/enseignant/enseignantModifier";
    }

    @Override
    @PostMapping(path = "/enseignant/modifier", name = "modifier")
    public String modifierPost(@ModelAttribute Enseignant enseignantModifier) {
        enseignantBusiness.modifier(enseignantModifier , enseignantModifier.getId());

        return getRedirectEnseignant;
    }

}
