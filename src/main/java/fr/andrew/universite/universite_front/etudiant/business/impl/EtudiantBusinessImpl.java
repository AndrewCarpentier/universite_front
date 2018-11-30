package fr.andrew.universite.universite_front.etudiant.business.impl;

import fr.andrew.universite.universite_front.etudiant.business.IEtudiantBusiness;
import fr.andrew.universite.universite_front.etudiant.domain.Etudiant;
import fr.andrew.universite.universite_front.etudiant.repository.IEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantBusinessImpl implements IEtudiantBusiness {

    @Autowired
    private IEtudiantRepository etudiantRepository;


    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findOneById(Integer id) {
        return etudiantRepository.getOne(id);
    }

    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.add(etudiant);
    }

    @Override
    public Void modifier(Etudiant etudiant, Integer id) {
        return etudiantRepository.update(etudiant, id);
    }

    @Override
    public Void delete(Integer id) {
        etudiantRepository.delete(id);

        return null;
    }




}
