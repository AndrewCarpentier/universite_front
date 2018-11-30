package fr.andrew.universite.universite_front.matiere.business.impl;

import fr.andrew.universite.universite_front.enseignant.business.IEnseignantBusiness;
import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import fr.andrew.universite.universite_front.matiere.business.IMatiereBusiness;
import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.matiere.repository.IMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatiereBusinessImpl implements IMatiereBusiness {

    @Autowired
    private IMatiereRepository matiereRepository;

    @Autowired
    private IEnseignantBusiness enseignantBusiness;

    @Override
    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere findOneById(Integer id) {
        return matiereRepository.getOne(id);
    }

    @Override
    public Matiere add(Matiere matiere) {
        return matiereRepository.add(matiere);
    }

    @Override
    public Void modifier(Matiere matiere, Integer id) {
        return matiereRepository.update(matiere, id);
    }

    @Override
    public Void delete(Integer id) {
        matiereRepository.delete(id);
        return null;
    }

    @Override
    public List<Enseignant> getEnseignant() {
        return enseignantBusiness.findAll();
    }

    @Override
    public Enseignant getEnseignantByID(Integer id) {
        return enseignantBusiness.findOneById(id);
    }
}
