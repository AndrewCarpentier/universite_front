package fr.andrew.universite.universite_front.etudiant.controller.impl;

import fr.andrew.universite.universite_front.etudiant.business.IEtudiantBusiness;
import fr.andrew.universite.universite_front.etudiant.controller.IEtudiantController;
import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class EtudiantControllerImpl implements IEtudiantController {

    @Autowired
    private IEtudiantBusiness etudiantBusiness;

    private static String getRedirectEtudiant = "redirect:/etudiant";



    @Override
    @GetMapping(path = "/etudiant", name = "etudiant")
    public String findAll(Model model) {
        List<Etudiant> etudiant = etudiantBusiness.findAll();
        model.addAttribute("etudiants", etudiant);

        return "etudiant/etudiant";
    }

    @Override
    @GetMapping(path = "/etudiant/detail", name = "detail")
    public String findOneById(Model model, @RequestParam Integer id) {
        Etudiant etudiant = etudiantBusiness.findOneById(id);
        model.addAttribute("etudiantDetail", etudiant);
        return "etudiant/etudiantDetail";
    }

    @Override
    @GetMapping(path = "/etudiant/add", name = "add")
    public String add(Model model) {
        Etudiant etudiant = new Etudiant();
        etudiant.setSexe("M");
        model.addAttribute("etudiantAdd", etudiant);

        return "etudiant/etudiantAdd";
    }

    @Override
    @PostMapping(path = "/etudiant/add", name = "add")
    public String addPost(@ModelAttribute Etudiant etudiantAdd) {
        etudiantBusiness.add(etudiantAdd);

        return getRedirectEtudiant;
    }

    @Override
    @GetMapping(path = "/etudiant/delete", name = "delete")
    public String delete(@RequestParam Integer id) {
        etudiantBusiness.delete(id);

        return getRedirectEtudiant;
    }

    @Override
    @GetMapping(path = "/etudiant/modifier", name = "modifier")
    public String modifier(Model model, @RequestParam Integer id) {
        Etudiant etudiant = etudiantBusiness.findOneById(id);
        model.addAttribute(etudiant);

        return "/etudiant/etudiantModifier";
    }

    @Override
    @PostMapping(path = "/etudiant/modifier", name = "modifier")
    public String modifierPost(@ModelAttribute Etudiant etudiant) {
        etudiantBusiness.modifier(etudiant, etudiant.getId());

        return getRedirectEtudiant;
    }

    @Override
    @GetMapping(path = "/etudiant/note", name = "note")
    public String note(Model model, @RequestParam Integer id) {
        model.addAttribute("etudiant", etudiantBusiness.findOneById(id));

        return "etudiant/etudiantNote";
    }


}
