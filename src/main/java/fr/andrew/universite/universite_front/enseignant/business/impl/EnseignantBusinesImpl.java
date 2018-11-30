package fr.andrew.universite.universite_front.enseignant.business.impl;

import fr.andrew.universite.universite_front.enseignant.business.IEnseignantBusiness;
import fr.andrew.universite.universite_front.enseignant.domain.Enseignant;
import fr.andrew.universite.universite_front.enseignant.repository.IEnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnseignantBusinesImpl implements IEnseignantBusiness {

    @Autowired
    private IEnseignantRepository enseignantRepository;

    @Override
    public List<Enseignant> findAll() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant findOneById(Integer id) {
        return enseignantRepository.getOne(id);
    }

    @Override
    public Enseignant add(Enseignant enseignant) {
        return enseignantRepository.add(enseignant);
    }

    @Override
    public Void modifier(Enseignant enseignant, Integer id) {
        enseignantRepository.update(enseignant, id );
        return null;
    }

    @Override
    public Void delete(Integer id) {
        enseignantRepository.deleteById(id);
        return null;
    }

}
